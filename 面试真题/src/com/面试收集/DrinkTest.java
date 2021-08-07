/**
 * 设计Java程序，假设有50瓶饮料，喝完三个空瓶可以换一瓶饮料，依次类推，请问总共喝了多少饮料。
 */
public class DrinkTest {
    public static void main(String[] args) {
        int n = 50;
        int i = 0;
        while (true) {
            n -= 3;
            n++;
            i++;
            if(n < 3) {
                System.out.println(50 + i);
                break;
            }
        }
    }
}
