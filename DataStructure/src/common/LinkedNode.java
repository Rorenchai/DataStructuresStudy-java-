/**
 * 链表结点类：被单链表、链栈、链队列复用。
 * 所属知识点：公共基础类
 * 要点：提供 data 数据域、next 地址域，以及 getData/setData/getNext/setNext 方法。
 */
package common;

public class LinkedNode <T> {
        private T data;
        private LinkedNode<T> next;
        //构造方法
        public LinkedNode() {

        }
        public LinkedNode(T data) {
            this.data = data;
        }
        public LinkedNode(T data, LinkedNode<T> next) {
            this.data = data;
            this.next = next;
        }
//setter和getter方法
                public T getData() {
                    return data;
                }
                    public void setData(T data) {
                        this.data = data;
                    }
                        public LinkedNode<T> getNext() {
                            return next;
                        }
                            public void setNext(LinkedNode<T> next) {
                                this.next = next;

                            }

                        }


