/**
 * 顺序表测试类（Student 元素）。
 * 所属知识点：线性表 · 顺序存储
 * 要点：以学生对象为元素演示增删改查，验证 equals 参与 indexOf、contains 比较的效果。
 */
package seqlist;

import common.Student;

public class TestStudentSeqList {
    public static void main(String[] args) {
        SeqList<Student> list1 =new SeqList<Student>(5);
        System.out.println("1 创建空顺序表（容量5）");
        list1.printList();

        System.out.println("2 用数组创建线性表");

        Student stu1=new Student("1101","李阳",90);
        Student stu2=new Student("1102","李飞",99);
        Student stu3=new Student("1103","张宇",97);
        Student[] arr1={stu1,stu2,stu3};
        SeqList<Student> list2 =new SeqList<Student>(arr1);
        list2.printList();

        Student value =list2.get(1);
        System.out.println("线性表中的第二个元素是:"+value);

        Student stunew=new Student("1108","学生new",49);
;       Student valuenew =list2.get(2);
        System.out.println("替换后线性表中的第三个元素是:"+valuenew);

        System.out.println("线性表中的长度："+list2.size());
        System.out.println("线性表是否为空："+list2.isEmpty());

       /* System.out.println("清空后线性表中的长度："+list2.size());
        System.out.println("清空后线性表是否为空："+list2.isEmpty());*/

        // 测试indexOf和contains方法
        System.out.println("调用indexOf方法查找30在线性表中的位置: " + list2.indexOf(stunew));
        System.out.println("调用contains方法判断线性表是否包含stunew: " + list2.contains(stunew));

        Student stunew2 =new Student("1109","学生new2",86);
        list2.insert(3,stunew2);
        System.out.println("--------输入插入元素stunew2后的顺序表-------- ");
        list2.printList();

        Integer[] arr5 = { 41, 51, 30, 80, 50 };
        SeqList<Integer> list5 = new SeqList<>(arr5);
        list5.remove(3);
        System.out.println("--------删除第4个元素后的顺序表-------- ");
        list5.printList();
    }
}
