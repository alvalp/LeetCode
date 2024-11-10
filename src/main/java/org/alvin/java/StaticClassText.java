package org.alvin.java;

public class StaticClassText {

    static class B{
        // class B 的一个属性,
        int b ;
    }

    public static  void function(B a){
        // a 是值传递， a 和外部的a 指向同一个空间，
        // 但是内部的a 重新赋值，指向了一个新对象。 并修改新对象的b。这样不影响外部的a
        a = new B();
        a.b = 20;
    }

    public static void main(String[] args) {
        B a = new B();
        a.b = 10;
        // 表明 B 可以创建很多个， 每个类都有自己单独的空间。
        B c = new B();
        c.b =  15;
        function(a);
        System.out.println(a.b);
        System.out.println(c.b);
    }
}
