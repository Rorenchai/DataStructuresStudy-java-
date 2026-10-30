/**
 * 有序单链表合并工具类。
 * 所属知识点：线性表 · 链式存储
 * 要点：同时遍历升序链表 listA、listB，把较小元素依次插入 listC，实现归并。
 */
package linkedlist;

public class MergeLinkedList {

    public void merge(SinglyLinkedList listA, SinglyLinkedList listB, SinglyLinkedList listC) {
        Node pa = listA.head.next;
        Node pb = listB.head.next;

        // 两表均从第一个元素开始依次扫描、比较
        while (pa != null && pb != null) {
            if ((Integer) pa.data < (Integer) pb.data) {  // 将较小的数据插入到 listC
                listC.insert(pa.data);
                pa = pa.next;
            } else {
                listC.insert(pb.data);
                pb = pb.next;
            }
        }

        while (pa != null) {          // listA 有剩余
            listC.insert(pa.data);
            pa = pa.next;
        }

        while (pb != null) {          // listB 有剩余
            listC.insert(pb.data);
            pb = pb.next;
        }
    }
}