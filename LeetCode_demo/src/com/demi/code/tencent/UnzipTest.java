package com.demi.code.tencent;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 解压缩
 * 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，
 * 于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
 * 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，
 * 例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 */
public class UnzipTest {
    public static void main(String[] args) {
        String a = "HG[3|B[2|CA]]F";
        //String a = "ABCABCABC";
        System.out.println(compress(a));
    }

    public static String compress (String str) {
        if(!str.contains("[")){
            return str;
        }
        StringBuilder sb=new StringBuilder(str);
        int len=str.length();
        char[] ch=str.toCharArray();
        // 栈
        Deque<Integer> stack=new LinkedList<>();
        for(int i=0;i<len;i++){
            if(ch[i]=='['){
                stack.push(i);
            }else if(ch[i]==']'){
                int l=stack.pop();
                int r=i;
                // 这里取出的字符串 s 就是去除[]后的字符串，有价值的字符串
                String s=str.substring(l+1,r);
                // 通过helper方法得到[]中的字符串
                String res=helper(s);
                // 先删除，在插入操作
                sb.delete(l,r+1);
                sb.insert(l,res);
                break;
            }
        }
        // 替换完成，调用该方法，实现递归，直到没有[]为止
        return compress(sb.toString());
    }

    //拆分[]括号中的
    public static String helper(String str){
        StringBuilder sb=new StringBuilder();
        // 遇到分割符'|'，进行划分
        String[] d=str.split("\\|");
        int num=Integer.parseInt(d[0]);
        String s=d[1];
        // 复制num份数据
        for(int i=0;i<num;i++){
            sb.append(s);
        }
        return sb.toString();
    }


    /*public static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // 当遇到'['符号时，进行迭代，求出[]的内容
            if (str.charAt(i) == '[') {
                // temp是括号[]中的内容，其中[0]是数据部分，[1]是对应的位置，
                String[] temp = getValue(i + 1, str);
                sb.append(temp[0]);
                i = Integer.parseInt(temp[1]);
            } else {
                // 不是 '['括号，就直接添加
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    private static String[] getValue(int index, String str) {
        String[] get = new String[2];
        int right = -1;
        // 记录下需要重复的次数
        int sum = 0;

        for (int i = index; i < str.length(); i++) {
            // 需要判断 | 的位置
            if (str.charAt(i) != '|') {
                // 还没到达 | 处，说明需要重复的次数大于9次，即至少10次
                sum += sum * 10 + Integer.parseInt(str.substring(i, i + 1));
            } else {
                right = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        // 计算[]中的内容，如果再次出现 '['，则继续迭代，出现 ']'，则说明内容已经读取完毕
        for (int i = right; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                String[] temp = getValue(i + 1, str);
                i = Integer.parseInt(temp[1]);
                sb.append(temp[0]);
            } else if (str.charAt(i) == ']') {
                right = i;
                break;
            } else {
                // 其他情况，即不是'[' ']'的情况，直接追加字符到sb中
                sb.append(str.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        // 将压缩的文字内容继续解压，即不断复制
        for (int i = 0; i < sum; i++) {
            stringBuilder.append(sb.toString());
        }
        get[0] = stringBuilder.toString();
        get[1] = String.valueOf(right);
        return get;
    }*/
}
