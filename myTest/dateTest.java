package myTest;

import java.util.TreeSet;

public class dateTest {
    public static void main(String[] args) {

        //方式一：Student类实现Comparable接口，重写里面的抽象方法
        //1.创建三个学生对象
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);

        //2.创建集合对象
        TreeSet<Student> ts = new TreeSet<>();

        //就算没有打印，创建集合后添加元素时一定要先重写Sort方法，否则会报错
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);

        System.out.println(ts);
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    @Override
    public int compareTo(Student o) {
        //指定排序的规则：
        //只看年龄，想要按照年龄的升序进行排列
        return this.getAge() - o.getAge();
    }
}