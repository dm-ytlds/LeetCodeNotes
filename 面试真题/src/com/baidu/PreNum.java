import java.util.Scanner;

/**
 * 百度笔试.2021.9.7：完美数。
 * 思路：
 *  转换成字符数组，正向考虑。（1）只要有字符大于'3'，后面的字符都得变成3；
 *          （2）有字符为'0'，如果是首字符，指针后移，如果不是首字符，将该字符置为最大数字字符'9'，指针减1，字符减1；
 *          （3）满足 字符 > '0' and 字符 < '3'，则指针后移即可。
 */
public class PreNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; ++i) {
            String str = in.next();
            char[] chars = str.toCharArray();
            int j = 0;
            while (j < chars.length) {
                if (chars[j] > '3') {
                    break;
                } else if (chars[j] == '0') {
                    if (j == 0) {
                        j++;
                        break;
                    }
                    chars[j] = '9';
                    j--;
                    chars[j]--;
                } else j++;
            }
            for (; j < chars.length; j++) {
                chars[j] = '3';
            }
            System.out.println(Long.parseLong(new String(chars)));
        }
    }
}
