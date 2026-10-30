/**
 * 栈的应用：字符串逆置。
 * 所属知识点：栈
 * 要点：字符串逐字符入栈再依次出栈，得到逆序结果（如 STACK → KCATS）。
 */
package stack;

public class ReverseDemo {

    /** 字符串逆置：STACK -> KCATS */
    public static String reverse(String s) {
        if (s == null) {
            return null;
        }

        LinkedStack<Character> st = new LinkedStack<>();

        // 1. 字符依次入栈
        for (char c : s.toCharArray()) {
            st.push(c);
        }

        // 2. 出栈顺序 = 入栈的逆序
        StringBuilder sb = new StringBuilder(s.length());
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("STACK"));   // KCATS
        System.out.println(reverse("hello"));   // olleh
        System.out.println(reverse("12345"));   // 54321
        System.out.println(reverse("a"));       // a
        System.out.println("[" + reverse("") + "]"); // []
    }
}
