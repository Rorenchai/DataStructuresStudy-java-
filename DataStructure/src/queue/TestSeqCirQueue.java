/**
 * 循环顺序队列测试类。
 * 所属知识点：队列
 * 要点：演示初始化、连续入队、两次出队、再入队、连续出队和判空。
 */
package queue;

public class TestSeqCirQueue {
        public static void main(String[] args) {
//队列初始化
            SeqCirQueue<String> scq=new SeqCirQueue<String>(5);
            System.out.println("队列为空:"+scq.isEmpty());
//元素入队
            scq. enqueue("a");
            scq. enqueue("b");
            scq. enqueue("c");
            scq. enqueue("d");
            System.out.println("队中元素为:"+scq);

//元素出队
            scq.dequeue(); //allB
            scq. dequeue(); //btB
            System.out.println("队中元素为:"+scq);
//元素e f入队
            scq. enqueue("e");
            scq. enqueue("f");
            System.out.println("队中元素为:"+scq);
//元素c d e f 出队,即出队4次
            scq.dequeue();
            scq.dequeue();
            scq.dequeue();
            scq.dequeue();
            System.out.println("队列为空:"+scq.isEmpty());

        }

}

