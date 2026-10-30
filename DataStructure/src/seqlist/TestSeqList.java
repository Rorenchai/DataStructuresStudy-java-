/**
 * 顺序表测试类（Integer 元素）。
 * 所属知识点：线性表 · 顺序存储
 * 要点：演示空表、数组建表，以及 get、set、size、isEmpty、indexOf、contains、insert、remove 的运行结果。
 */
package seqlist;

public class TestSeqList {
    public static void main(String[] args){
        SeqList<Integer> list1 =new SeqList<Integer>(5);
        System.out.println("1 创建空顺序表（容量5）");
        list1.printList();

        System.out.println("2 用数组创建线性表");
        Integer[] arr1={10,20,30,40,50};
        SeqList<Integer> list2 =new SeqList<Integer>(arr1);
        list2.printList();

        Integer value =list2.get(1);
        System.out.println("线性表中的第二个元素是:"+value);

        list2.set(2,100);
        Integer valuenew =list2.get(2);
        System.out.println("替换后线性表中的第三个元素是:"+valuenew);

        System.out.println("线性表中的长度："+list2.size());
        System.out.println("线性表是否为空："+list2.isEmpty());

        System.out.println("清空后线性表中的长度："+list2.size());
        System.out.println("清空后线性表是否为空："+list2.isEmpty());

        // 测试indexOf和contains方法
        Integer[] arr3 = { 60, 70, 60, 80, 50 };
        SeqList<Integer> list3 = new SeqList<>(arr3);
        System.out.println("调用indexOf方法查找30在线性表中的位置: " + list3.indexOf(30));
        System.out.println("调用contains方法判断线性表是否包含50: " + list3.contains(50));
        System.out.println("调用contains方法判断线性表是否包含60: " + list3.contains(60));

        Integer[] arr4 = { 61, 71, 30, 60, 50 };
        SeqList<Integer> list4 = new SeqList<>(arr4);
        list4.insert(3,80);
        System.out.println("--------输入插入元素80后的顺序表-------- ");
        list4.printList();

        Integer[] arr5 = { 41, 51, 30, 80, 50 };
        SeqList<Integer> list5 = new SeqList<>(arr5);
        list5.remove(3);
        System.out.println("--------删除第4个元素后的顺序表-------- ");
        list5.printList();
    }
}
