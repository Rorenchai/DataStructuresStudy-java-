/**
 * 链栈实现类（复用 LinkedNode）。
 * 所属知识点：栈
 * 要点：以链表头为栈顶，头插法入栈、头删法出栈，实现入栈、出栈、取栈顶、判空。
 */
package stack;

import common.LinkedNode;

public class LinkedStack<T> { // 删掉了 implements Stack<T>
    private LinkedNode<T> top;

    public LinkedStack() {
        top = null;
    }

    // 入栈
    public void push(T t) {
        LinkedNode<T> node = new LinkedNode<T>(t);
        node.setNext(top);
        top = node;
    }

    // 出栈
    public T pop() {
        if(this.isEmpty()){
            throw new RuntimeException("栈为空，无法出栈");
        }
        T val = top.getData();
        top = top.getNext();
        return val;
    }

    // 取栈顶元素
    public T peek() {
        if(this.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        return top.getData();
    }

    // 判断为空
    public boolean isEmpty() {
        return top == null;
    }
}