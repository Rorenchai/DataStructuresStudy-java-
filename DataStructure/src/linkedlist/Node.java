/**
 * 单链表结点类。
 * 所属知识点：线性表 · 链式存储
 * 要点：每个结点含 data 数据域和 next 地址域，是 SinglyLinkedList、MergeLinkedList 的基本单元。
 */
package linkedlist;

//单链表结点类，T是数据元素的类型
    public class Node<T> {
        public T data; // 数据域，存储数据元素
        public Node<T> next; // 地址域，引用后续结点

        public Node(T data, Node<T> next) { // 由指定的两个域来构造结点
            this.data = data;
            this.next = next;
        }

        public Node() { // 空构造
            this(null, null);
        }

        public String toString() {
            return this.data.toString(); // 返回结点数据域的描述字符串

        }
}