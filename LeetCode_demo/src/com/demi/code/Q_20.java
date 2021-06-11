package com.demi.code;

import java.util.*;

/**题目：有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *  左括号必须用相同类型的右括号闭合。
 *  左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 */
public class Q_20 {
    public static void main(String[] args) {

    }


    /**
     * 题解：用 栈 求解
     *  判断括号的有效性，首选用 栈 数据结构。
     *  遍历给定的字符串s。当遇到一个左括号时，我们会期望在后续的遍历中，有一个相同类型的右括号将其闭合。由于后遇到的左括号要先闭合，因此我们可以将这个左括号放入栈顶。
     *  当我们遇到一个右括号时，我们需要将一个相同类型的左括号闭合。此时，我们可以取出栈顶的左括号并判断它们是否是相同类型的括号。如果不是，或者栈中没有左括号，那么字符串s无效。返回False，为了快速判断括号的类型，我们可以使用hashMap存储每一种括号，键为右括号，值为左括号。
     *  在遍历结束后，如果栈中没有左括号，说明我们将字符串s中的所有左括号闭合，返回true，否则返回false。
     *  注意首先判断字符串是否是偶数个，奇数个字符串直接返回false。
     *
     * @param s   给定字符串
     * @return    返回是否完全配对的判别
     */
    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 != 0) return false;
        // 栈
        // 将字符串存入栈中
        Deque<Character> stack = new LinkedList<>();;
        // 将所有的括号类型预存入hashmap集合，键值对就是一对括号
        // 注意：括号的顺序得是反的
        Map<Character, Character> chars = new HashMap<>();
        chars.put(')', '(');
        chars.put(']', '[');
        chars.put('}', '{');
        // 循环遍历字符串字符
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if(chars.containsKey(c)) {

                if(stack.isEmpty() || stack.peek() != chars.get(c))
                    return false;
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
