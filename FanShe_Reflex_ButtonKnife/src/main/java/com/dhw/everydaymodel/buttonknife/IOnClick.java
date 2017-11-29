package com.dhw.everydaymodel.buttonknife;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解类
 * @Override    用于修饰此方法覆盖了父类的方法;
 * @Deprecated  用于修饰已经过时的方法;
 * @suppressWarings("deprecation") 用于通知java编译器忽略特定的编译警告。
 */

/**
 * 自定义注解：
 1.成员类型是受限的，合法的类型包括原始类型及String,Calss,Anootation,Enumreation
 2.如果注解已有一个成员，则成员名必须取名为Vaue(),在使用的时可以忽略成员名和赋值号（=）
 3.注解类可以没有成员，没有成员的注解称为标识注解
 */
/**
 * 元注解
   @Target({ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD})
   Target 注解的作用域   CONSTRUCTOR 构造方法声明，FIELD 字段声明，LOCAL_VARIABLE 局部变量声明 ，METHOD 方法声明，PACKAGE 包声明，PARAMETER 参数声明，TYPE 类接口。

   @Retention(RetentionPolicy.RUNTIME)
   Retention 生命周期 SOURCE 只在源码显示，编译时会丢弃，CLASS 编译时会记录到class中，运行时忽略，RUNTIME 运行时存在，可以通过反射读取。

   @Inherited
   Inherited 允许子类继承

   @Documented
   Documented 生成javadoc的时候包含注解
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IOnClick {    //使用@interface关键字注解
    //String name();        //成员以无参无异常方式声明
    //String author();
    //int age() default 19;//可以用default为成员变量指定一个默认值

    int value();
}
