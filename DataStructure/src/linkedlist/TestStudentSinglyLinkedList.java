/**
 * 单链表测试类（Student 元素）。
 * 所属知识点：线性表 · 链式存储
 * 要点：以学生对象为元素演示单链表的增删改查和遍历输出。
 */
package linkedlist;

import common.Student;

public class TestStudentSinglyLinkedList {

    public static void main(String[] args) {

        // ===== 1. 创建空表 =====
        SinglyLinkedList<Student> list1 = new SinglyLinkedList<Student>();
        System.out.println("1 创建空顺序表：");
        list1.printList();

        // ===== 2. 用数组创建线性表 =====
        System.out.println("2 用数组创建线性表");
        Student stu1 = new Student("1101", "李阳", 90);
        Student stu2 = new Student("1102", "李晨", 78);
        Student stu3 = new Student("1103", "李三", 89);   // 原 "il" 改为正常姓名
        Student[] arr1 = {stu1, stu2, stu3};
        SinglyLinkedList<Student> list2 = new SinglyLinkedList<Student>(arr1);
        list2.printList();

        // ===== 测试 get、set =====
        Student value = list2.get(1);
        System.out.println("线性表中的第2个元素是:" + value);

        Student stunew = new Student("1108", "学生new", 86);
        list2.set(2, stunew);
        Student valuenew = list2.get(2);
        System.out.println("替换后线性表中的第3个元素是:" + valuenew);
        list2.printList();

        // ===== 测试 size、isEmpty =====
        System.out.println("线性表中的长度:" + list2.size());
        System.out.println("线性表是否为空:" + list2.isEmpty());

        // ===== 测试 indexOf、contains =====
        System.out.println("调用indexOf方法查找stunew在线性表中的位置:"
                + list2.indexOf(stunew));
        System.out.println("调用contains方法判断线性表是否包含stunew:"
                + list2.contains(stunew));

        // ===== 测试 insert（指定下标）=====
        Student stunew2 = new Student("1109", "学生new2", 86);
        list2.insert(3, stunew2);        // 在第4个位置插入
        System.out.println("--输出插入元素stunew2后的顺序--");
        list2.printList();

        // ===== 测试 insert（末尾追加）=====
        Student stunew3 = new Student("1110", "学生new3", 86);
        list2.insert(stunew3);
        System.out.println("---输出插入元素stunew3后的顺序表---");
        list2.printList();

        // ===== 测试 remove（先删后打印）=====
        list2.remove(3);                 // 先删除第4个元素
        System.out.println("-----删除第4个元素后的顺序表-----");
        list2.printList();
    }
}