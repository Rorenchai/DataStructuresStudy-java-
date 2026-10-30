/**
 * 作业版顺序表（char 字符表）。
 * 所属知识点：线性表 · 顺序存储
 * 要点：用 char 数组自行实现顺序表（满时扩容一倍），完整演示创建、批量插入、指定位置插入、删除、查找、修改、遍历。
 */
package seqlist;

public class SeqListDemo_homework {

    private char[] data;
    private int size;
    private int capacity;

    // 1. 创建顺序表：初始容量为 5
    public SeqListDemo_homework(int capacity) {
        this.capacity = capacity;
        this.data = new char[capacity];
        this.size = 0;
        System.out.println("【创建顺序表】初始容量: " + capacity);
        print();
    }

    // 在指定位置插入元素
    public void insert(int index, char ch) {
        if (index < 0 || index > size) {
            System.out.println("插入位置不合法！");
            return;
        }
        if (size >= capacity) {
            // 扩容为原来的2倍
            capacity *= 2;
            char[] newData = new char[capacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
            System.out.println("  (容量不足，已扩容至 " + capacity + ")");
        }
        // 后移元素
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = ch;
        size++;
    }

    // 在末尾插入元素
    public void add(char ch) {
        insert(size, ch);
    }

    // 删除指定位置元素
    public char remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("删除位置不合法！");
            return '\0';
        }
        char removed = data[index];
        // 前移元素
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removed;
    }

    // 查找元素，返回下标（找不到返回 -1）
    public int indexOf(char ch) {
        for (int i = 0; i < size; i++) {
            if (data[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    // 修改指定位置的元素
    public void set(int index, char ch) {
        if (index < 0 || index >= size) {
            System.out.println("修改位置不合法！");
            return;
        }
        data[index] = ch;
    }

    // 遍历输出顺序表
    public void print() {
        System.out.print("  当前顺序表 [" + size + "/" + capacity + "]: [");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // 1. 创建顺序表，初始容量为 5
        SeqListDemo_homework list = new SeqListDemo_homework(5);
        System.out.println();

        // 2. 批量插入：依次插入 'A'、'B'、'C'、'D'、'E'
        System.out.println("【批量插入】依次插入 A, B, C, D, E");
        char[] batch = {'A', 'B', 'C', 'D', 'E'};
        for (char ch : batch) {
            list.add(ch);
            System.out.println("  插入 '" + ch + "' 后");
        }
        list.print();
        System.out.println();

        // 3. 指定位置插入：在下标 2 处插入 'X'
        System.out.println("【指定位置插入】在下标 2 处插入 'X'");
        list.insert(2, 'X');
        list.print();
        System.out.println();

        // 4. 删除元素：删除下标 4 处的字符
        System.out.println("【删除元素】删除下标 4 处的字符");
        char removed = list.remove(4);
        System.out.println("  删除了 '" + removed + "'");
        list.print();
        System.out.println();

        // 5. 查找元素：查找字符 'C' 的位置
        System.out.println("【查找元素】查找字符 'C' 的位置");
        int pos = list.indexOf('C');
        if (pos != -1) {
            System.out.println("  字符 'C' 的下标为: " + pos);
        } else {
            System.out.println("  未找到字符 'C'");
        }
        list.print();
        System.out.println();

        // 6. 修改元素：将下标 1 处的字符改为 'Z'
        System.out.println("【修改元素】将下标 1 处的字符改为 'Z'");
        list.set(1, 'Z');
        list.print();
        System.out.println();

        // 7. 遍历输出（最终状态）
        System.out.println("【最终遍历输出】");
        list.print();
    }
}
