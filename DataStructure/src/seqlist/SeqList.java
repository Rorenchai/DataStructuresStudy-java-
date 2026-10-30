/**
 * 顺序表实现类：用数组存储线性表元素。
 * 所属知识点：线性表 · 顺序存储
 * 要点：实现 LinearList 接口；容量不足时自动扩容一倍，插入后移、删除前移，另提供逆置 reverse()。
 */
package seqlist;

import common.LinearList;

// SeqList.java
public class SeqList<T> implements LinearList<T> {
    protected T[] data;
    protected int n;

    @SuppressWarnings("unchecked")
    public SeqList(int length) {
        this.data = (T[]) new Object[length];
        this.n = 0;
    }

    public SeqList(T[] values) {
        this(values.length);
        for (int i = 0; i < values.length; i++) {
            this.data[i] = values[i];
        }
        this.n = values.length;
    }

    public SeqList() {
        this(10);
    }

    @Override
    public T get(int i) {
        if (i >= 0 && i < this.n) return this.data[i];
        throw new IndexOutOfBoundsException(i + "下标越界");
    }

    @Override
    public void set(int i, T t) {
        if (t == null) throw new NullPointerException("t==null");
        if (i >= 0 && i < this.n) this.data[i] = t;
        else throw new IndexOutOfBoundsException(i + "下标越界");
    }

    @Override
    public int insert(T t) {
        return insert(this.n, t);
    }

    @SuppressWarnings("unchecked")
    @Override
    public int insert(int i, T t) {
        if (t == null) throw new NullPointerException("t==null");
        if (i < 0 || i > this.n)
            throw new IndexOutOfBoundsException(i + "下标越界");

        if (this.n == this.data.length) {              // 扩容
            T[] src = this.data;
            this.data = (T[]) new Object[src.length * 2];
            for (int j = 0; j < src.length; j++) {
                this.data[j] = src[j];
            }
        }
        for (int j = this.n - 1; j >= i; j--) {        // 后移
            this.data[j + 1] = this.data[j];
        }
        this.data[i] = t;
        this.n++;
        return i;
    }

    @Override
    public T remove(int i) {
        if (this.n == 0)
            throw new IllegalStateException("空表无法删除！");
        if (i < 0 || i >= this.n)
            throw new IndexOutOfBoundsException(i + "下标越界");

        T old = this.data[i];
        for (int j = i; j < this.n - 1; j++) {
            this.data[j] = this.data[j + 1];
        }
        this.data[this.n - 1] = null;
        this.n--;
        return old;
    }

    @Override
    public boolean contains(T key) {
        return indexOf(key) != -1;
    }

    @Override
    public int indexOf(T key) {
        if (key != null) {
            for (int i = 0; i < this.n; i++) {
                if (key.equals(this.data[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public int size() { return this.n; }

    @Override
    public void clear() { this.n = 0; }

    @Override
    public boolean isEmpty() { return this.n == 0; }

    public void printList() {
        for (int i = 0; i < this.n; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }                                         // ← 这里补上了 }

    // 顺序表逆置（对自身）
    public void reverse() {
        T t;
        for (int i = 0, j = this.n - 1; i < j; i++, j--) {
            t = this.data[i];
            this.data[i] = this.data[j];
            this.data[j] = t;
        }
    }

    // 如果老师要求“传参版本”，可保留下面这个：
    public void reverse(SeqList<T> list) {
        T t;
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            t = list.data[i];
            list.data[i] = list.data[j];
            list.data[j] = t;
        }
    }
}