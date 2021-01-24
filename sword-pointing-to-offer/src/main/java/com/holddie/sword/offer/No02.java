package com.holddie.sword.offer;

/**
 * 单例模式
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/2 8:56
 */
public class No02 {
    public static void main(String[] args) {

        A a = A.getInstance();
        B b = B.getInstance();
    }
}

/**
 * 饿汉模式
 *
 * @author HoldDie
 * @version v1.0.0
 * @email HoldDie@163.com
 * @date 2018/5/2 8:57
 */
class A {
    private static final A a = new A();

    private A() {}

    public static A getInstance() {
        return a;
    }
}

/**
 * 懒汉模式
 *
 * @author HoldDie
 * @version v1.0.0
 * @email HoldDie@163.com
 * @date 2018/5/2 9:01
 */
class B {
    private static volatile B b = null;

    private B() {}

    public static B getInstance() {
        if (b == null) {
            synchronized (B.class) {
                if (b == null) {
                    b = new B();
                }
            }
        }
        return b;
    }
}
