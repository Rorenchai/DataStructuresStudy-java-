/**
 * 有序单链表合并测试类。
 * 所属知识点：线性表 · 链式存储
 * 要点：由两个升序数组构造单链表，调用 MergeLinkedList.merge 合并后打印结果。
 */
package linkedlist;

public class MergeLinkedListTest {

    public static void main(String[] args) {
// 通过有序数组创建顺序表listA,listB
        Integer a[] = { 12, 36, 89, 100 };
        Integer b[] = { 22, 43, 91, 112, 120 };
        SinglyLinkedList listA = new SinglyLinkedList(a);
        SinglyLinkedList listB = new SinglyLinkedList(b);

        SinglyLinkedList listC = new SinglyLinkedList();
// 创建顺序表listC-空表
        MergeLinkedList ml = new MergeLinkedList();
        ml.merge(listA,listB, listC);//有序顺序表合并

        listC.printList();//输出顺序表listC

    }
}
