package com.dhw.everydaymodel;

import java.lang.reflect.Constructor;

//反射Reflex的简单用法
public class UserTest {

        //定义一个main函数
        public static void main(String [] args) throws Exception{
            User s = new User();  //实例化User类对象

            //获取Student类的class对象的包名.类名（3种方法）
            //第1种：Class.forName("包名.类名"，即 全类名);    常用
            Class<?> clazz = Class.forName("com.dhw.everydaymodel.User");
            System.out.println("clazz："+clazz);

            //第2种：Class 对象名=类名.class
            Class clazz2 = User.class;
            //System.out.println("clazz2："+clazz2);

            //第3种：对象名.getclass（使用此方法先实例化Student类）
            Class<? extends User> clazz3= s.getClass();
            //System.out.println("clazz3："+clazz3);

            //获取当前类的所有构造方法
            Constructor[] constructor1 = clazz.getDeclaredConstructors();
            //获取当前class 的所有public构造方法
            Constructor[] constructor2 = clazz.getConstructors();
            for (Constructor constructor : constructor2){
                System.out.println("构造方法："+constructor);
            }
        }
    }

