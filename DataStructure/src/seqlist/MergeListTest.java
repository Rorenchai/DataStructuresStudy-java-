/**
 * 有序顺序表合并测试类。
 * 所属知识点：线性表 · 顺序存储
 * 要点：由两个升序数组构造顺序表，调用 MergeList.merge 合并后输出结果。
 */
package seqlist;

public class MergeListTest {
    public static void main(String[] args) {
        // 通过有序数组创建顺序表 listA、listB
        Integer[] a = {12, 36, 89, 100};
        Integer[] b = {22, 43, 91, 112, 120};

        SeqList<Integer> listA = new SeqList<>(a);
        SeqList<Integer> listB = new SeqList<>(b);

        SeqList<Integer> listC = new SeqList<>(); // 创建空表 listC

        MergeList ml = new MergeList();
        ml.merge(listA, listB, listC); // 有序顺序表合并

        listC.printList(); // 输出顺序表 listC
    }
}