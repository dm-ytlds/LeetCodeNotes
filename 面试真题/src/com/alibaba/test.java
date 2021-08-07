import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner no = new Scanner(System.in);
        // 测试组数
        int test = no.nextInt();
        // 雨棚数量
        int n = no.nextInt();
        int[][] nums = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                nums[i][j] = no.nextInt();
            }
        }
        int cs = 0;
        double max  = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
           double res = Math.sqrt(Math.pow(nums[i][0] - nums[i][2], 2) + Math.pow(nums[i][1] - nums[i][3], 2)) * nums[i][4]  / (nums[i][0] - nums[i][2]);
           if (res < max) {
               max = res;
               cs = i + 1;
           }
        }
        System.out.println(cs);
    }
}
