/**
 * 学生实体类：顺序表、链表测试中使用的元素类型。
 * 所属知识点：公共基础类
 * 要点：保存学号、姓名、成绩，重写 toString、equals、hashCode，便于验证查找与删除。
 */
package common;

import java.util.Objects;

public class Student {
    private String no;
    private String name;
    private double score;

    public Student(){
        super();
    }
    public Student(String no, String name, double score){
        super();
        this.no=no;
        this.name=name;
        this.score=score;

    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(score, student.score) == 0 && Objects.equals(no, student.no) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name, score);
    }
}
