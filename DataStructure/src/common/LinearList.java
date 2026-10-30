/**
 * 线性表接口：规定顺序表和单链表共有的抽象操作。
 * 所属知识点：公共基础类
 * 要点：声明 get、set、insert、remove、contains、indexOf、size、clear、isEmpty、printList，由两种存储结构各自实现。
 */
package common;

// LinearList.java
public interface LinearList<T> {
    public T get(int i);             // 返回下标为i的元素
    public void set(int i, T t);     // 用指定元素t替换表中指定位置i的元素
    public int insert(T t);          // 在线性表的最后插入元素t，返回t序号
    public int insert(int i, T t);   // 在线性表的位置i处插入元素t，返回t序号
    public T remove(int i);          // 删除下标为i的元素，返回被删除的元素
    public boolean contains(T key);  // 判断线性表中是否包含key元素
    public int indexOf(T key);       // 在线性表查找首次出现的与key相等元素，返回元素位置，若不存在，则返回-1
    public int size();               // 返回线性表的长度
    public void clear();             // 清空线性表
    public boolean isEmpty();        // 判断线性表是否为空
    public void printList();         // 遍历顺序表所有元素
}