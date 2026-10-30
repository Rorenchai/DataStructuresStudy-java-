/**
 * 带头结点的单链表实现类。
 * 所属知识点：线性表 · 链式存储
 * 要点：实现 LinearList 接口；尾插法建表，提供按位取/改、插入、删除、判包含、求长度、清空、遍历。
 */
package linkedlist;

import common.LinearList;

public class SinglyLinkedList<T> implements LinearList<T> {
    public Node<T> head; // 单链表的头指针，指向头结点

    public SinglyLinkedList() { // 构造空单链表
        head = new Node<T>(); // 创建头结点，data和next的值均为null
    }

    //尾插法构造链表
    public SinglyLinkedList(T[] values) {
        this();                        // 创建只有头结点的单链表
        Node<T> rear = this.head;      // rear 指向尾结点
        for (int i = 0; i < values.length; i++) {
            rear.next = new Node<T>(values[i], null);  // 尾插法
            rear = rear.next;          // rear 指向新的尾结点
        }
    }

    public T get(int i) {
        Node<T> p = this.head.next;    // 从第 1 个数据结点开始
        for (int j = 0; p != null && j < i; j++)
            p = p.next;                // 一步一步往后走
        if (i < 0 || p == null)        // 走完了还没到，说明 i 越界
            throw new IndexOutOfBoundsException(i);
        return p.data;                 // 返回第 i 个结点的数据
    }

    public void set(int i, T x) {
        Node<T> p = this.head.next;    // 从第 1 个数据结点开始
        for (int j = 0; p != null && j < i; j++)
            p = p.next;                // 一步一步走到第 i 个结点
        if (i < 0 || p == null)
            throw new IndexOutOfBoundsException(i);
        T old = p.data;                // 记住旧值
        p.data = x;                    // 修改数据域
    }
    @Override
    public int insert(T t) {
        return this.insert(this.size(), t);
    }

    // 在aᵢ前插入元素t，若插入成功，返回i，否则返回-1
    public int insert(int i, T t) {
        int j=0;
        if(t==null) throw new NullPointerException("不能插入空对象！");
        //抛出空对象异常
        Node<T> p=this.head;
        while(p.next!=null&&j<i){//寻找aᵢ₋₁结点
            p=p.next;
            j++;
        }
        if(p!=null&&j==i){  //找到aᵢ₋₁结点
            Node<T> s=new Node<T>(t,p.next); //建立新结点，数据域为元素t，地址域为p.next
            p.next=s;    //在p之后插入新结点
            return i;    //插入成功，返回i
        }else{
            return -1;   //插入失败，返回-1
        }
    }


    //删除结点aᵢ
    public T remove(int i) {
        int j=0;
        Node<T> p=this.head;
        while (p.next!=null && j<i) {   //寻找aᵢ₋₁结点
            p=p.next;
            j++;
        }
        if (p.next!=null && j==i) {        //aᵢ结点存在
            T old=p.next.data;             //保存待删除结点的数据域
            p.next=p.next.next;            /*删除结点，包括开始、中间和尾结点删除*/
            return old;                    //返回已删除结点的数据域
        } else {
            return null;                   //i越界，返回null
        }
    }

    @Override
//判断单链表中是否包含key元素
    public boolean contains(T key) {
        Node p=this.head.next;
        for(;p!=null;p=p.next){    //遍历单链表
            if(p.data.equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T key) {
        int i = 0;
        Node p = this.head.next;       // 从第一个数据结点开始
        for (; p != null; p = p.next) {    // 遍历单链表
            if (p.data.equals(key)) {
                return i;              // 找到，返回下标
            }
            i++;
        }
        return -1;                     // 走完整条链都没找到
    }

    //返回单链表的长度
    public int size() {
        int n=0;
        Node p=this.head.next;
        while(p!=null){
            n++;
            p=p.next;
        }
        return n;
    }

    //清空单链表
    public void clear(){
        this.head.next=null;
    }

    //判断单链表是否为空
    public boolean isEmpty() {
        return this.head.next==null;
    }


    //遍历单链表
    public void printList() {
        Node p=this.head.next;
        while(p!=null){
            System.out.println(p.data); //输出结点的数据域
            p=p.next; //指针后移一个结点
        }
    }

}