package org.lili.forfun.spring.reading.demo;

/**
 * 普通对象的循环依赖
 *
 * @author lili
 * @date 2020/11/22 13:28
 * @notes
 */
class A {
    public A() {
        new B();
    }
}

class B {
    public B() {
        new A();
    }
}

/**
 * 循环依赖不是spring特有的问题，而是java本身的问题，，在spring中可以得到解决
 */
public class CircularDependenciesTest {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        //Exception in thread "main" java.lang.StackOverflowError
        //	at org.lili.demo.A.<init>(CircularDependenciesTest.java:10)
        //	at org.lili.demo.B.<init>(CircularDependenciesTest.java:16)
        //	at org.lili.demo.A.<init>(CircularDependenciesTest.java:10)
        //	at org.lili.demo.B.<init>(CircularDependenciesTest.java:16)
        //	at org.lili.demo.A.<init>(CircularDependenciesTest.java:10)
        //	at org.lili.demo.B.<init>(CircularDependenciesTest.java:16)
        //	at org.lili.demo.A.<init>(CircularDependenciesTest.java:10)
        //	at org.lili.demo.B.<init>(CircularDependenciesTest.java:16)
    }
}
