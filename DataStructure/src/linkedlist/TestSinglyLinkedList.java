/**
 * 单链表测试类（Integer 元素）。
 * 所属知识点：线性表 · 链式存储
 * 要点：演示建表、get/set、size/clear/isEmpty、indexOf/contains、insert/remove 等操作。
 */
package linkedlist;

public class TestSinglyLinkedList {
        public static void main(String[] args) {
            SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
            System.out.println("1 创建空链表");
                    list1.printList();

            System.out.println("2 用数组创建链表");
                    Integer[] arr1 = { 10, 20, 30, 40, 50 };
            SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>(arr1);
            list2.printList();

// 测试get、set方法
// 获取线性表中的第2个元素
            Integer value = list2.get(1);
            System.out.println("链表中的第2个元素是:"+value);

// 线性表中的第3个元素替换成100
            list2.set(2, 100);
            Integer valuenew = list2.get(2);
            System.out.println("替换后链表中的第3个元素是:"+valuenew);
// 测试size、clear、isEmpty方法
                    System.out.println("链表表中的长度:"+list2.size());
            System.out.println("链表表是否为空:"+list2.isEmpty());

            list2.clear();// 把线性表清空
            System.out.println("清空后链表中的长度:"+list2.size());
            System.out.println("清空后链表是否为空:"+list2.isEmpty());

// 测试indexOf和contains方法
            Integer[] arr3 = { 10, 20, 30, 40, 50 };
            SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>(arr3);
            System.out.println("调用indexOf方法查找30在链表中的位置:"+list3.indexOf(30));
            System.out.println("调用contains方法判断链表是否包含50:"+list3.contains(50));
            System.out.println("调用contains方法判断链表是否包含60:"+list3.contains(60));

// 测试insert方法
            Integer[] arr4 = { 10, 20, 30, 40, 50 };
            SinglyLinkedList<Integer> list4 = new SinglyLinkedList<>(arr3);
            list4.insert(3,80);//在第4个位置插入元素80
            System.out.println(" -----输出插入元素80后的链表----- ");

            list4.printList();//输出插入元素80后的链表

// 测试remove方法
            Integer[] arr5 = { 10, 20, 30, 40, 50 };
            SinglyLinkedList<Integer> list5 = new SinglyLinkedList<>(arr5);
            list5.remove(3);//删除第4个元素
            System. out.println("-----删除第4个元素后的链表----- ");
            list5.printList();

        }
}
