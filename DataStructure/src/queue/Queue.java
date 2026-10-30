/**
 * 队列接口：定义队列的基本操作。
 * 所属知识点：队列
 * 要点：声明 enqueue、dequeue、peek、isEmpty，供循环顺序队列和链队列实现。
 */
package queue;

public interface Queue<T>{
    public void  enqueue(T t);
    public T dequeue();
    public T peek();
    public boolean isEmpty();
}
