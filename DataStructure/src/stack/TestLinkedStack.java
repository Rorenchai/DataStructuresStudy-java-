/**
 * 链栈测试类。
 * 所属知识点：栈
 * 要点：演示判空、入栈、取栈顶、连续出栈和再次判空。
 */
package stack;

public class TestLinkedStack {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedStack<String> ls=new LinkedStack<String>();
        System.out.println(ls.isEmpty());
        ls.push("a");
        ls.push("b");
        ls.push("c");
        System.out.println(ls.peek());
        //元素出栈
        String str1 = ls.pop();
        String str2 = ls.pop();
        String str3 = ls.pop();
        System.out.println("出栈元素: "+str1+str2+str3);
        //判断栈是否为空
        System.out.println(ls.isEmpty());
    }
}