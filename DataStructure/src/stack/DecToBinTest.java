/**
 * 栈的应用：十进制整数转二进制。
 * 所属知识点：栈
 * 要点：不断对 2 取余并入栈，最后依次出栈拼接成二进制串。
 */
package stack;

public class DecToBinTest {
    public static String decToBin(int n) {
        // 特殊情况处理：0的二进制是0 (果冻鸡翅的版本漏掉了这个判断)
        if (n == 0) {
            return "0";
        }

        LinkedStack<Integer> st = new LinkedStack<>();
        while (n > 0) {
            st.push(n % 2);
            n = n / 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 13;
        String res = decToBin(num);
        System.out.println(num + " 转二进制：" + res);
    }
}