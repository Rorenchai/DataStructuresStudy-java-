/**
 * 栈接口：定义栈的基本操作。
 * 所属知识点：栈
 * 要点：声明 push、pop、peek、isEmpty；类名 Stark 沿用原写法（即 Stack 的笔误），未重命名。
 */
package stack;

public interface Stark<T> {
    public void push(T t);//入栈操作
    public T pop();//出栈操作,返回值是栈顶元素
    public T peek();//取栈顶元素,不出栈
    public boolean isEmpty();//判断栈是否为空

}