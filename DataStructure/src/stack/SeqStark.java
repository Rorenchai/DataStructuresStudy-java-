/**
 * 顺序栈实现类：用数组实现栈。
 * 所属知识点：栈
 * 要点：用数组存放元素、top 指针指向栈顶，实现 Stark 接口的入栈、出栈、取栈顶和判空。
 */
package stack;

public class SeqStark<T> implements Stark<T> {
    private T[] stack = null;   // 声明一维数组,表示顺序栈
    private int length;         // 表示顺序栈的容量
    private int top;            // 栈顶指针

    // 栈初始化(默认容量 16)
    @SuppressWarnings("unchecked")
    public SeqStark() {
        stack = (T[]) new Object[16];  // 构造一维的泛型数组,默认大小为 16
        length = 16;
        top = -1;                      // 栈初始化,栈中没有元素
    }

    // 栈初始化(指定容量)
    @SuppressWarnings("unchecked")
    public SeqStark(int size) {
        stack = (T[]) new Object[size];  // 构造一维的泛型数组,大小由参数决定
        length = size;
        top = -1;
    }

    // 入栈
    @Override
    public void push(T t) {
        if (top == length - 1) {
            // 或者抛出异常,或者扩容
            throw new RuntimeException("栈已满");
        }
        stack[++top] = t;
    }

    // 出栈
    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("栈为空");
        }else {
            return stack[top--];
        }
    }

    // 取栈顶元素(不出栈)
    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return stack[top];
    }

    // 判断栈是否为空
    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}