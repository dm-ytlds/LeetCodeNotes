import java.util.*;

public class Poker01 {
    public static void main(String[] args) {
        // 准备花色和牌面
        List<String> colors = new ArrayList<>();
        colors.add("♠");
        colors.add("♦");
        colors.add("♣");
        colors.add("♥");

        // 准备牌面
        List<String> numbers = new ArrayList<>();
        Collections.addAll(numbers, "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2");

        // 用HashMap集合存储牌面
        int index = 0;
        Map<Integer, String> cards = new HashMap<>();
        for (String number : numbers) {
            for (String color : colors) {
                cards.put(index++, color + number);
            }
        }
        // 大小王别忘了
        cards.put(index++, "大王");
        cards.put(index++, "小王");

        // 只用数字进行洗牌，最后发牌的时候在通过key 提取出cards中的value牌面
        List<Integer> cardsNo = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            cardsNo.add(i);
        }
        // 打乱顺序
        Collections.shuffle(cardsNo);

        // 发牌的序号
        // 准备3为选手，和底牌存放数组
        List<Integer> player01 = new ArrayList<>();
        List<Integer> player02 = new ArrayList<>();
        List<Integer> player03 = new ArrayList<>();
        List<Integer> oCards = new ArrayList<>();
        for (int i = 0; i < cardsNo.size(); i++) {
            if (i >= 51) {
                oCards.add(cardsNo.get(i));
            } else {
                if (i % 3 == 0) {
                    player01.add(cardsNo.get(i));
                } else if (i % 3 == 1) {
                    player02.add(cardsNo.get(i));
                } else {
                    player03.add(cardsNo.get(i));
                }
            }
        }

        // 整理牌面
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(oCards);

        // 牌序号对应的牌面
        List<String> sPlayer01 = new ArrayList<>();
        List<String> sPlayer02 = new ArrayList<>();
        List<String> sPlayer03 = new ArrayList<>();
        List<String> sOCards = new ArrayList<>();
        for (Integer key01 : player01) {
            sPlayer01.add(cards.get(key01));
        }
        for (Integer key02 : player02) {
            sPlayer02.add(cards.get(key02));
        }
        for (Integer key03 : player03) {
            sPlayer03.add(cards.get(key03));
        }

        for (Integer key : oCards) {
            sOCards.add(cards.get(key));
        }

        // 看牌
        System.out.println(sPlayer01);
        System.out.println(sPlayer02);
        System.out.println(sPlayer03);
        System.out.println(sOCards);
    }
}
