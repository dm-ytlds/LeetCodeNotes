package src.com.algorithms.dynamicProgramming;

/** 从左往右的尝试模型1
 * 1->A
 * 2->B
 * ...
 * 26->Z
 * 给定数字字符串，将数字字符串转换成相应的字符字符串。
 * 示例：
 *  s = "111";
 *  可转换的字符串有：
 *  new_s = "AAA", "KA", "AK"
 */
public class Question03 {
    public static void main(String[] args) {
        String s = "1111";

        int nums = dpProcess(s);
        System.out.println(nums);
    }
    /**
     * i位置为起始位置。
     * 起始位置的i 在取0时，0没有对应的字符，所有返回0种转换结果；
     * 起始位置的i 在取1时，1对应的字符是A，可以继续向后转换，形成多个结果，所以用到递归来实现；
     * 起始位置的i 在取2时，2对应的字符是B，数字字符串以2开头的紧接着的数字最多到6，当然，从第三个数字字符开始就不确定了，还是要递归找全部；
     * 起始位置的i 在取3时，3对应的字符是C，后面无论接什么数字字符都会出现超过26的情况，所以此时只有一种情况，即"3"->"C"。
     * 起始位置的i 在取4~9时，和取3的情况是一样的。可以一起考虑。
     * str[0, ... ,i]已经转化结束了
     * i位置之前，如何转化已经做过决定了
     * 只需要考虑i位置之后，有多少种转化的结果
     * @param str
     * @return dp[0]
     */
    public static int dpProcess(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int N = chars.length;
        int[] dp = new int[N + 1];
        // 假如字符数组只有一个i字符，则只对应1种结果
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            // i 没有到终止位置
            // 遇到 '0' 字符，'0'字符没有对应的字符，所以返回0种结果
            if (chars[i] == '0') {
                dp[i] = 0;
            }

            // str[i]字符串不是'0'
            // str[i]字符串为'1'
            else if (chars[i] == '1') {
                // i自己作为单独的部分
                dp[i] = dp[i + 1];
                if (i + 1 < N) {
                    // 把i和i+1作为单独的部分
                    dp[i] += dp[i + 2];
                }
            }
            // str[i]字符串为'2'
            else if (chars[i] == '2') {
                dp[i] = dp[i + 1];
                if(i + 1 < N && (chars[i + 1] >= '0' && chars[i + 1] <='6')) {
                    // 如果i + 1位置的值在'0'到'6'之间
                    // 就将i和i+1作为单独部分，探讨后续的结果个数
                    dp[i] += dp[i + 2];
                }
            }else {
                // str[i] == '3' ~ '9'的情况
                dp[i] += dp[i + 1];
            }
        }


        return dp[0];
    }
}
