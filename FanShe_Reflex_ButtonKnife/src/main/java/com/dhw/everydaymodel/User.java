package com.dhw.everydaymodel;

public class User {
    private String name;  //姓名属性
    private int     age;  //年龄属性

    //有参和无参构造方法
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public User() { }

    //封装属性
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void sleep(){
        System.out.println("User sleep = ");
    }

    //输出属性信息
    @Override
    public String toString() {
        return "age=" + age + ", name=" + name +"岁";
    }

    //无参无返回值方法
    public void study(){
        System.out.println("我学过“马列毛邓三科”。");
    }
    //有参无返回值方法
    public void love(String name){
        System.out.println(name+"就爱克拉拉。");
    }
    //有参有返回值方法
    public int he(int a,int b){
        return a+b;
    }
    //无参有返回值方法
    public int zhi(){
        return 20*5;
    }
}
