/**
 * 有序顺序表合并工具类。
 * 所属知识点：线性表 · 顺序存储
 * 要点：双指针扫描升序表 listA、listB，把较小元素依次插入 listC，实现归并。
 */
package seqlist;

public class MergeList {
    // 有序顺序表的合并
    public void merge(SeqList listA, SeqList listB, SeqList listC) {
        listC.clear();
        int i = 0, j = 0;

        while (i < listA.size() && j < listB.size()) {
            Integer x = (Integer) listA.get(i);
            Integer y = (Integer) listB.get(j);
            if (x < y) {
                listC.insert(x);
                i++;
            } else {
                listC.insert(y);
                j++;
            }
        }
        while (i < listA.size()) {
            listC.insert((Integer) listA.get(i));
            i++;
        }
        while (j < listB.size()) {
            listC.insert((Integer) listB.get(j));
            j++;
        }
    }
}