import java.util.Scanner;

/** 题目描述：
 *  已知xy = b, x + y = a, 求 x^n + y^n 的值。
 *  输入：
 *      第一行：输入一个正整数，表示有几行数参与运算
 *      第二行开始：输入a, b, n
 *      ...
 */
/*public class demo01 {
    static int mod = 1000000007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 运算的次数
        int epoch = sc.nextInt();
        while(epoch-- > 0){
            // 分别输入a, b, n
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            if(n == 0){
                System.out.println(2);
                continue;
            }else if(n == 1){
                System.out.println(a);
                continue;
            }
            // ppre初始代表n == 0时的值
            long ppre = 2;
            // pre初始代表n == 1时的值
            long pre = a;
            long cur = 0;
            for(int i = 2; i <= n; i++){
                // x + y = a
                // xy = b
                // x^n + y^n = a * (x^(n-1) + y^(n-1)) - b * a^(n-2)
                cur = ((a*pre - b*ppre)%mod + mod)%mod;
                ppre = pre;
                pre = cur;
            }
            System.out.println(cur);
        }
    }
}*/

public class demo01 {
    static final int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入要运算的次数
        int iter = sc.nextInt();
        while (iter > 0) {
            iter --;
            // 输入每一行的a,b,n
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            if(n == 0) {
                System.out.println(2);
                continue;
            }
            else if(n == 1) {
                System.out.println(a);
                continue;
            }
            else {
                long pre = a;
                long head = 2;
                long curr = 0;
                // 从n等于2开始
                for (int i = 2; i <= n; i++) {
                    curr = ((a * pre - b * head) % mod + mod) % mod;
                    head = pre;
                    pre = curr;
                }
                System.out.println(curr);
            }
        }
    }
}


