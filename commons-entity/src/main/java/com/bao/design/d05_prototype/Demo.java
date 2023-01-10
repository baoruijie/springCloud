package com.bao.design.d05_prototype;

public class Demo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.setName("八嘎");
        student.setAge(23);
        System.out.println(student);

        Student student1 = (Student)student.clone();
        System.out.println(student.equals(student1));
        System.out.println(student == student1);
        System.out.println(student);
        System.out.println(student1);
    }



}
