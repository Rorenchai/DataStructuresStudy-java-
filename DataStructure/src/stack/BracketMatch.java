/**
 * 栈的应用：括号匹配判断。
 * 所属知识点：栈
 * 要点：左括号入栈、右括号出栈比对类型，判断 ()、[]、{} 是否正确配对，main 中带多种测试用例。
 */
package stack;

/**
 * 括号匹配测试类
 */
public class BracketMatch {

    /**
     * 括号匹配算法
     * 依照图2的思路：左括号入栈，右括号出栈比较
     */
    public static boolean isMatch(String s) {
        // 防御性处理：空串视为匹配成功
        if (s == null || s.isEmpty()) {
            return true;
        }

        LinkedStack<Character> st = new LinkedStack<>();

        // 读取表达式字符串，依次对其中的字符进行判断
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 1. 若 ch 是左括号，则入栈
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            }
            // 2. 若 ch 是右括号，则先判断栈是否为空
            else if (c == ')' || c == ']' || c == '}') {

                // 若栈为空，则表示此右括号是多余的
                if (st.isEmpty()) {
                    return false;
                }

                // 栈不空，弹出栈顶左括号进行比较
                char top = st.pop();

                // 若不是同类括号，则表示括号嵌套错误
                if ((top == '(' && c != ')') ||
                        (top == '[' && c != ']') ||
                        (top == '{' && c != '}')) {
                    return false;
                }
            }
            // 其他字符（字母、数字、运算符等）直接忽略
        }

        // 遍历结束后，如果栈为空，说明所有左括号都找到了匹配的右括号
        // 如果栈不为空，说明左括号多余了
        return st.isEmpty();
    }

    // ================= 测试方法 =================
    public static void main(String[] args) {
        String[] testCases = {
                "()",
                "()[]{}",
                "{[()]}",
                "(]",
                "([)]",
                "((()))",
                "(",
                ")",
                "a * (b + c)"
        };

        for (String s : testCases) {
            System.out.printf("表达式: %-10s -> 匹配结果: %b\n", s, isMatch(s));
        }
    }
}