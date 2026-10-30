/**
 * 队列的应用：十进制小数转二进制小数。
 * 所属知识点：队列
 * 要点：用 java.util.Queue 把“乘 2 取整”得到的位依次入队，再出队拼接成二进制小数。
 */
package queue;

import java.util.LinkedList;
import java.util.Queue;

public class DecimalToBinary {
    /**
     * 十进制小数转二进制小数
     * @param x      十进制小数 (0 < x < 1)
     * @param digits 保留的二进制小数位数 (防止无限循环小数死循环)
     * @return 二进制小数字符串
     */
    public static String decToBin(double x, int digits) {
        // 使用 LinkedList 实现队列
        Queue<Integer> q = new LinkedList<>();

        // 循环条件：未达到指定精度 且 小数部分大于0
        for (int i = 0; i < digits && x > 0; i++) {
            x = x * 2;                  // 乘以2
            int bit = (int) x;          // 获取整数部分 (0 或 1)
            x = x - bit;                // 更新 x 为剩下的小数部分
            q.offer(bit);               // 整数位入队 (图片中为 q.enqueue)
        }

        // 拼接结果
        StringBuilder sb = new StringBuilder("0.");
        while (!q.isEmpty()) {
            sb.append(q.poll());        // 依次出队并拼接 (图片中为 q.dequeue)
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decToBin(0.625, 10)); // 输出: 0.101
        System.out.println(decToBin(0.8125, 10)); // 输出: 0.1101
        System.out.println(decToBin(0.1, 8));    // 输出: 0.00011001 (0.1是无限循环小数，受限于digits)
    }
}