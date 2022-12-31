import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：
 * 将整数字符转换成字符串，其中 0-9 对应"0" - "9"
 *      * 10 - 35 对应 "A" - "Z"
 *      * 36 对应 "10"
 */
public class Test01 {
    /**
     * 实现思路：需要递归，因为商可能出现大于36的情况
     * @param value
     * @return
     */
    public static String numToString(int value) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");
        map.put(8, "8");
        map.put(9, "9");

        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
        map.put(16, "G");
        map.put(17, "H");
        map.put(18, "I");
        map.put(19, "J");

        map.put(20, "K");
        map.put(21, "L");
        map.put(22, "M");
        map.put(23, "N");
        map.put(24, "O");
        map.put(25, "P");
        map.put(26, "Q");
        map.put(27, "R");
        map.put(28, "S");
        map.put(29, "T");

        map.put(30, "U");
        map.put(31, "V");
        map.put(32, "W");
        map.put(33, "X");
        map.put(34, "Y");
        map.put(35, "Z");
        map.put(36, "10");

        StringBuilder sb = new StringBuilder();
        if(value <= 36) {
            sb.append(map.get(value));
        } else {
            int a = value / 36;
            int b = value % 36;
            sb.append(numToString(a));
            sb.append(map.get(b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(numToString(71000));
    }

}
