/**
 * 基于 LinkedNode 的单链表类（不带头结点）。
 * 所属知识点：线性表 · 链式存储
 * 要点：提供头插法、尾插法、按索引取值、按值删除、求长度、判空和打印。
 */
package linkedlist;

import common.LinkedNode;

// 基于 LinkedNode 实现的单链表
public class LinknodeList<T> {
    private LinkedNode<T> head; // 头结点
    private int size;           // 链表长度

    public LinknodeList() {
        this.head = null;
        this.size = 0;
    }

    // 1. 头插法
    public void addFirst(T data) {
        LinkedNode<T> newNode = new LinkedNode<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    // 2. 尾插法
    public void addLast(T data) {
        LinkedNode<T> newNode = new LinkedNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            LinkedNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // 3. 按索引获取元素
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界: " + index);
        }
        LinkedNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    // 4. 按值删除元素
    public boolean remove(T data) {
        if (head == null) return false;

        // 如果要删除的是头结点
        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return true;
        }

        // 删除中间或尾部结点
        LinkedNode<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false; // 未找到该元素
    }

    // 5. 获取链表长度
    public int size() {
        return size;
    }

    // 6. 判断链表是否为空
    public boolean isEmpty() {
        return head == null;
    }

    // 7. 打印链表所有元素
    public void printList() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        LinkedNode<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}