/**
 * 顺序栈测试类。
 * 所属知识点：栈
 * 要点：演示初始化、连续入栈、peek 取栈顶、连续出栈以及判空。
 */
package stack;

public class TestSeqStark {

    public static void main(String[] args) {
        SeqStark<String> ss=new SeqStark<String>();
        System.out.println(ss.isEmpty());
//元素进栈
        ss.push("a");
        ss.push("b");
        ss.push("c");
        ss.push("d");
//输出栈顶元素
        System.out.println(ss.peek());
//元素出栈
        ss.pop();
        ss.pop();
        ss.pop();
        ss.pop();
//判断栈是否为空
        System.out.println(ss.isEmpty());

    }

}