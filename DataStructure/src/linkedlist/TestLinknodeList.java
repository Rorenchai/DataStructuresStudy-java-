/**
 * LinknodeList 测试类。
 * 所属知识点：线性表 · 链式存储
 * 要点：依次演示尾插、头插、按索引取值、按值删除，并检查长度和判空结果。
 */
package linkedlist;

public class TestLinknodeList {
    public static void main(String[] args) {
        System.out.println("========== 开始测试 LinknodeList ==========");
        // 注意：这里使用的是您刚刚重命名好的 LinknodeList
        LinknodeList<String> list = new LinknodeList<>();

        // 1. 测试空链表
        System.out.println("当前链表是否为空: " + list.isEmpty());
        System.out.println("当前链表长度: " + list.size());

        // 2. 测试尾插法
        System.out.println("\n--- 测试尾插法 (addLast) ---");
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.printList(); // 预期: A -> B -> C -> null

        // 3. 测试头插法
        System.out.println("\n--- 测试头插法 (addFirst) ---");
        list.addFirst("X");
        list.printList(); // 预期: X -> A -> B -> C -> null

        // 4. 测试获取元素
        System.out.println("\n--- 测试按索引获取 (get) ---");
        System.out.println("索引 0 的元素: " + list.get(0)); // 预期: X
        System.out.println("索引 2 的元素: " + list.get(2)); // 预期: B

        // 5. 测试删除元素
        System.out.println("\n--- 测试删除 (remove) ---");
        System.out.println("删除元素 'A': " + list.remove("A")); // 预期: true
        list.printList(); // 预期: X -> B -> C -> null

        System.out.println("删除不存在的元素 'Z': " + list.remove("Z")); // 预期: false

        // 6. 测试最终状态
        System.out.println("\n--- 最终状态 ---");
        System.out.println("当前链表长度: " + list.size()); // 预期: 3
        System.out.println("当前链表是否为空: " + list.isEmpty()); // 预期: false
        System.out.println("========== 测试结束 ==========");
    }
}