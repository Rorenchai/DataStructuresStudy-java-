/**
 * 链栈的另一种实现（内部结点类版）。
 * 所属知识点：栈
 * 要点：用私有静态内部类 Node 作结点并维护 size 计数，提供 push、pop、peek、isEmpty、size。
 */
package stack;

/** 链栈 */
public class LinkedStack2<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> top;
    private int size;

    public LinkedStack2() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    /** 入栈：头插法 */
    public void push(T e) {
        top = new Node<>(e, top);
        size++;
    }

    /** 出栈 */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法出栈");
        }
        T e = top.data;
        top = top.next;
        size--;
        return e;
    }

    /** 取栈顶但不删除 */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无栈顶元素");
        }
        return top.data;
    }
}