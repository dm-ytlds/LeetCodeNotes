//import java.util.Scanner;
//
//public class HJ16 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int N = in.nextInt();  // 总总可用的钱数
//            int m = in.nextInt();  // 总共可以购买的物品数量
//            Goods[] goods = new Goods[m];
//            for (int i = 0; i < m; i++) {
//                int v = in.nextInt();
//                int p = in.nextInt();
//                int q = in.nextInt();
//                goods[i].value = v;
//                goods[i].price = p * v;  // 直接使用p * v，代表该物品的满意度
//                if (q == 0) {
//                    // 如果该物品为主件
//                    goods[i].main = true;
//                } else if (goods[q - 1].a1 == -1) {
//                    goods[q - 1].a1 = i;
//                } else {
//                    goods[q - 1].a2 = i;
//                }
//            }
//            int[][] dp = new int[m + 1][N + 1];
//            // 确定遍历顺序
//            for (int i = 1; i <= m; i++) {      // 可能的物品数量。从1开始，代表至少有一件物品
//                for (int j = 0; j <= N; j++) {  // 可能用多少钱
//                    // 默认
//                    dp[i][j] = dp[i - 1][j];
//                    // 如果该物品不是主件，则跳过此次循环
//                    if (!goods[i - 1].main) {
//                        continue;
//                    }
//                    if (j > goods[i - 1].value) {
//                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].value] + goods[i - 1].price);
//                    }
//                    if (goods[i - 1].a1 != -1 && j >= goods[i - 1].value + goods[goods[i - 1].a1].value) {
//                        dp[i][j] = Math.max(dp[i][j], dp[])
//                    }
//                }
//            }
//        }
//    }
//}
//
///**
// * 定义一个物品类
// */
//class Goods {
//    int value; // 重要度
//    int price; // 价格
//    boolean main = false; // 该物品是否为主件
//
//    // 一个主件最多有两个附件
//    int a1 = -1;  // 初始化附件1的编号
//    int a2 = -1;  // 初始化附件2的编号
//}
