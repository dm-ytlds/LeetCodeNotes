import java.util.ArrayList;
import java.util.List;

/**
 * 找出圆圈中最后生效的数字。
 * 描述：0, 1, 2, ..., n - 1这n个数字排成一个圆圈，从数字0开始，
 *  每次从圆圈中删除第m个数字(删除后从下一个数字开始计数)。
 *  求出这个圆圈里剩下的最后一个数字。
 */
public class Q_20210725 {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        System.out.println(lastNum(n, m));
    }

    public static int lastNum(int n , int m) {
        // 初始化数字列表
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(i);
        }
        int idx = 0;
        while (n > 1) {
            // 需要从环中去除的数字
            idx = (idx + m - 1) % n;
            lists.remove(idx);
            n--;
        }
        return lists.get(0);
    }
}
