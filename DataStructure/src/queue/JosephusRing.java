/**
 * 队列的应用：约瑟夫环。
 * 所属知识点：队列
 * 要点：用 Queue + LinkedQueue 模拟 n 个人围成一圈按 m 报数出列的过程，输出出列顺序。
 */
package queue;

/**
 * 约瑟夫环问题 —— 结合已有的 LinkedQueue 实现
 */
public class JosephusRing {

    // n 表示人数，m 是所报的数
    public void outQueue(int n, int m) {
        if (n <= 0 || m <= 0) {
            System.out.println("参数必须大于0！");
            return;
        }

        // 创建队列存放人（这里使用 queue 包下的 Queue 接口和 LinkedQueue 实现）
        Queue<Integer> rings = new LinkedQueue<Integer>();

        // n 个人按顺序入队
        for (int i = 1; i <= n; i++) {
            rings.enqueue(i);
        }

        int count = 0; // 统计报数
        System.out.print("出列顺序为：");

        while (!rings.isEmpty()) {              // 只要队列不空，一直报数
            Integer deq = rings.dequeue();      // 元素出队
            count++;                            // 报数加 1

            if (count % m == 0) {               // 正好报到 m，则输出（出列），否则再次入队
                System.out.print(deq + " ");    // 输出
                count = 0;                      // 报数归零
            } else {
                rings.enqueue(deq);             // 元素再次入队，到队尾
            }
        }
        System.out.println(); // 换行
    }

    public static void main(String[] args) {
        JosephusRing jr = new JosephusRing();

        System.out.println("【测试1：n=4, m=3（对应演示中的 a,b,c,d）】");
        jr.outQueue(4, 3);

        System.out.println("\n【测试2：n=10, m=3（对应演示中的 1~10）】");
        jr.outQueue(10, 3);
    }
}