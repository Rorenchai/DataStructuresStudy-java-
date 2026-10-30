/**
 * 作用：舞者实体类，用于演示“舞伴配对”队列应用。
 * 所属知识点：队列的应用。
 * 实现要点：仅包含名字属性，重写 toString 以便直接打印配对结果。
 */
package queue;

public class Dancer {
    private String name;

    public Dancer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}