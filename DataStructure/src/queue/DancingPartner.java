/**
 * 作用：队列的应用 —— 舞伴配对问题。
 * 所属知识点：队列。
 * 实现要点：
 * 1. 根据性别分别创建两个队列 Q1（女生）和 Q2（男生）。
 * 2. 每曲开始时，两个队头同时出队，配成一对并输出。
 * 3. 配对结束后，两人再次入到各自队尾，等待下一轮配对。
 * 4. 循环条件：!Q1.isEmpty() && !Q2.isEmpty()，配够 n 轮就 break。
 */
package queue;

public class DancingPartner {

    /**
     * 舞伴配对
     * @param Q1 女生队列
     * @param Q2 男生队列
     * @param n  需要配对的轮次（舞曲数量）
     */
    public void match(Queue<Dancer> Q1, Queue<Dancer> Q2, int n) {
        int count = 0; // 记录当前的轮次

        // 循环条件：两个队列都不为空
        while (!Q1.isEmpty() && !Q2.isEmpty()) {
            // 1. 两个队头同时出队
            Dancer female = Q1.dequeue();
            Dancer male = Q2.dequeue();

            // 2. 配成一对并输出
            count++;
            System.out.println("第 " + count + " 曲配对：" + female + " ---- " + male);

            // 3. 两人再次入到各自队尾，等待下一轮配对
            Q1.enqueue(female);
            Q2.enqueue(male);

            // 4. 配够 n 轮就 break
            if (count == n) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // 创建男女队列（这里使用你 queue 包下的 Queue 接口和 LinkedQueue 实现）
        Queue<Dancer> Q1 = new LinkedQueue<>();
        Queue<Dancer> Q2 = new LinkedQueue<>();

        // 准备数据（对应可视化演示：3 女 5 男）
        Q1.enqueue(new Dancer("lady1"));
        Q1.enqueue(new Dancer("lady2"));
        Q1.enqueue(new Dancer("lady3"));

        Q2.enqueue(new Dancer("gentleman1"));
        Q2.enqueue(new Dancer("gentleman2"));
        Q2.enqueue(new Dancer("gentleman3"));
        Q2.enqueue(new Dancer("gentleman4"));
        Q2.enqueue(new Dancer("gentleman5"));

        // 调用配对方法，进行 5 轮配对
        DancingPartner partner = new DancingPartner();
        partner.match(Q1, Q2, 5);
    }
}