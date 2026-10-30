/**
 * 循环顺序队列实现类。
 * 所属知识点：队列
 * 要点：数组加取模运算维护 front、rear 指针；判满时留空一个位置，避免队头队尾重叠。
 */
package queue;

import java.util.Arrays;

public class SeqCirQueue<T> implements Queue<T> {
    private T[] queue = null;    //声明一维数组，存储队列元素
    private int length;       //数组的大小，表示队列的最大容量
    private int front;        //表示队头位置
    private int rear;         //表示队尾位置

    //队列初始化
    public SeqCirQueue() {
        queue = (T[]) new Object[16]; //构造一维的泛型数组，默认大小为16，存储队列元素
        length = 16;
        front = rear = 0;    //初始队列为空
    }

    public SeqCirQueue(int length) {
        queue = (T[]) new Object[length]; //构造一维的泛型数组，存储队列元素
        this.length = length;
        front = rear = 0;    //初始队列为空
    }
    public void enqueue(T t) {
//判断队列是否满,若已满,则抛出异常,若未满,队尾位置向前移动1,插入元素
        if(front == (rear+1) % length) {
            throw new RuntimeException("队列已满,元素不能入队");
        }else {
            rear=(rear+1)%length;
            queue [rear]=t;

        }

    }

    //元素出队
    @Override
    public T dequeue() {
//判断队列是否空,若为空,抛出异常,若不为空,队头位置向前移动1,取出元素
        if(isEmpty()) {
            throw new RuntimeException("队列空,没有元素出队");
        }else {
            front=(front+1) %length;
            T t=queue [ front];
            queue [ front ]=null;
            return t;

        }

    }

    @Override
    public T peek() {
//判断队列是否空,若为空,抛出异常,若不为空,直接取出队头元素
        if(isEmpty()) {
            throw new RuntimeException("队列空,没有元素获取");
        }else {
            return queue [front+1];//直接将队头元素取出
        }
    }

    //判断队列是否为空
    @Override
    public boolean isEmpty() {
//队头和队尾指向同一个位置,表示队列为空
        return front == rear;
    }
//返回队列元素
        public String toString(){
            return Arrays.toString(queue);
        }
    }
//……