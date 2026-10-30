/**
 * 顺序表综合演示程序。
 * 所属知识点：线性表 · 顺序存储
 * 要点：用一个 SeqList<String> 依次演示插入、按位取值、修改、删除、查找和求长度。
 */
package seqlist;

// Main.java
public class Main {
    public static void main(String[] args) {
        // 1. 创建一个顺序表
        SeqList<String> list = new SeqList<>(5); // 初始容量为5

        // 2. 测试插入
        list.insert("A");
        list.insert("B");
        list.insert("C");
        list.insert(1, "X"); // 在索引1处插入X，原来的B会变成索引2

        System.out.print("当前顺序表内容: ");
        list.printList(); // 预期输出: A X B C

        // 3. 测试获取和修改
        System.out.println("获取下标2的元素: " + list.get(2)); // 预期输出: B
        list.set(2, "Y");
        System.out.print("修改后内容: ");
        list.printList(); // 预期输出: A X Y C

        // 4. 测试删除
        list.remove(0);
        System.out.print("删除索引0后内容: ");
        list.printList(); // 预期输出: X Y C

        // 5. 测试其他方法
        System.out.println("是否包含'Y': " + list.contains("Y")); // true
        System.out.println("'C'所在的下标: " + list.indexOf("C")); // 2
        System.out.println("当前长度: " + list.size()); // 3

    }
}