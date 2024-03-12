package myTest;

import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {

        //需求：字符串"aababcabcdabcde"
        //统计字符串中每一个字符出现的次数，并按照如下格式输出：
        //a(5)b(4)c(3)d(2)e(1)

        //如果题目中没有要求对结果进行排序，默认使用HashMap，效率最高
        //如果题目中要求对结果进行排序，那么就使用TreeMap

        String target = "aababcabcdabcde";
        TreeMap<Character, Integer> tm = new TreeMap<>();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (tm.containsKey(c)) {
                tm.put(c, tm.get(c) + 1);
            } else {
                tm.put(c, 1);
            }
        }

        Set<Character> characters = tm.keySet();
        for (Character character : characters) {
            System.out.print(character + "(" + tm.get(character) + ")");
        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Student o) {
        return (this.getAge() - o.getAge() == 0) ? this.getName().compareTo(o.getName()) : this.getAge() - o.getAge();
    }
}

