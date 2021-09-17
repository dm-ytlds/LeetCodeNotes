/**
 * LeetCode 1221题：将一个平衡字符串分割成更多的平衡字符子串
 */
public class Q_20210912 {
    public static void main(String[] args) {
        String s = "RLLLLRRRLRRL";
        System.out.println(balanceStringSplit02(s));
    }

    /**
     * 贪心+栈的思想。遇到R字符，计数器count + 1，遇到 L 字符，count - 1。
     * 当count = 0时，就是一个平衡字符串。
     * @param s
     * @return
     */
    private static int balanceStringSplit02(String s) {
        int count = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == 'R' ? 1 : -1;
            if (count == 0) {
                res++;
            }
        }
        return res;
    }

    /**
     * 暴力求解。一次遍历，如果L的个数等于R的个数，结果res+1。将L和R的个数重新计算。
     * 时间复杂度：O(n)；空间复杂度：O(1)。
     * @param s
     * @return
     */
    private static int balanceStringSplit01(String s) {
        int conL = 0, conR = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                conL++;
            }
            if (s.charAt(i) == 'R') {
                conR++;
            }
            if (conL == conR) {
                res++;
                conL = 0;
                conR = 0;
            }
        }
        return res;
    }
}
