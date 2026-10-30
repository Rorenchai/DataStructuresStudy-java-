/**
 * 链队列测试类。
 * 所属知识点：队列
 * 要点：演示判空、连续入队、打印队列、取队头元素和出队。
 */
package queue;

public class TestLinkedQueue {
    public static void main(String[] args) {
        LinkedQueue<String> lq=new LinkedQueue<String>();
        System.out.println("链队为空："+lq.isEmpty());
        //元素入队
        lq.enqueue("a");
        lq.enqueue("b");
        lq.enqueue("c");
        lq.enqueue("d");
        System.out.println(lq);
        System.out.println("队头元素为："+lq.peek());

        //元素出队
        lq.dequeue();
//        lq.dequeue();
        System.out.println("链队为空："+lq.isEmpty());
//        System.out.println("队头元素为："+lq.peek());
    }
}