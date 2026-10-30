/**
 * 链队列实现类（复用 LinkedNode）。
 * 所属知识点：队列
 * 要点：用 front、rear 指针和空的头结点管理队列，实现入队、出队、取队头、判空、求元素个数。
 */
package queue;

import common.LinkedNode;

//链式队列类
public class LinkedQueue<T> implements Queue<T> {
    private LinkedNode<T> front, rear; // 表示队头,队尾指针
    // 队列初始化
    public LinkedQueue() {
        front = rear = new LinkedNode<T>(); // 初始空队列，队头和队尾指向一个空的头结点
    }

    // 元素入队
    @Override
    public void enqueue(T t) {
        // 先构造新结点，再将新元素入队，在队尾处插入新结点，再移动队尾指针指向新结点
        LinkedNode<T> node = new LinkedNode<T>(t, null);
        rear.setNext(node); //新结点插入队尾
        rear = node;        //移动队尾指针
    }

    // 元素出队
    @Override
    public T dequeue() {
        // 先获取队头元素，再移动队头指针指向下一个结点，若队列只有一个元素，出队后队列为空，则移动队
        if (isEmpty())
            throw new RuntimeException("队列为空，没有元素可出队");
        LinkedNode<T> node = front.getNext(); //保存要出队的队头结点
        front.setNext(node.getNext());        //队头指针指向node的后继结点
        if (node.getNext() == null)            //若队列中只有一个元素
            rear = front;                      //元素出队后，队列为空，队尾和队头指针都指向头结点
        return node.getData();
    }

    // 取队头元素
    @Override
    public T peek() {
        // 判断队列是否为空，若为空，则抛出异常，若不为空，则获取队头元素。
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            return front.getNext().getData(); //取队头元素值返回
        }
    }

    // 判断链队是否为空
    @Override
    public boolean isEmpty() {
        if (front == rear) {
            return true;
        } else
            return false;
    }

    // 返回链队的元素
    public String toString() {
        StringBuffer strbuf = new StringBuffer();
        LinkedNode<T> temp = front;
        while (temp != rear) {
            temp = temp.getNext();
            strbuf.append(temp.getData() + "--");
        }
        return strbuf.toString();
    }

    //求队列中元素个数
    public int length() {
        int count=0;
        LinkedNode front=this.front;
        LinkedNode rear=this.rear;
        while(front!=rear) {
            count++;
            front=front.getNext();
        }
        return count;
    }
}