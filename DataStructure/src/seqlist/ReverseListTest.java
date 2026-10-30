/**
 * 顺序表逆置测试类。
 * 所属知识点：线性表 · 顺序存储
 * 要点：调用 SeqList.reverse(list) 把元素首尾对调，打印逆置前后的结果。
 */
package seqlist;

public class ReverseListTest {
    public static void main(String[] args) {
        Integer a[]={25,30,20,45,60,12,37,69};
        SeqList<Integer> list=new SeqList<Integer>(a);

        System.out.println("逆置前：");
        list.printList();//输出逆置前的顺序表

        list.reverse(list);//顺序表逆置

        System.out.println("\n逆置后：");
        list.printList();//输出逆置后的顺序表
    }
}