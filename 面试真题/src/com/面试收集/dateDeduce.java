import java.util.Scanner;

/**
 * 根据某年某月某日，输出这是一年中第几天。
 */
public class dateDeduce {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入三个数字，分别代表年月日：");
        int year = s.nextInt();
        int month = s.nextInt();
        int day = s.nextInt();
        // 分出闰年和平年
        int[][] days = {{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                        {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
        int sum = 0;
        // 计算到前一个月就可。
        for (int i = 0; i < month - 1; i++) {
            if (year % 4 == 0 & year % 100 != 0 | year % 400 == 0) {
                sum = sum + days[1][i];
            } else {
                sum = sum + days[0][i];
            }
        }
        sum = sum + day;
        System.out.println(year + "年" + month + "月" + day + "日，是一年中的第" + sum + "天。");
    }
}
