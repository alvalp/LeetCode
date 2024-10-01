package org.alvin.java;

import java.nio.charset.StandardCharsets;

public class StringTest {

    public static void main(String[] args) {

        byte[] content = new byte[10];

        String s = new String(content, StandardCharsets.UTF_8);

//        Long l = Long.valueOf(s);

        byte a = 127;
        byte b = 127;

//        byte c = a+b;

        a += b;
        System.out.println(a);
        System.out.println(3 * 0.1 == 0.3);
        functio1();
//        functio2();
    }


    public static void functio1()throws IllegalArgumentException{
        throw new IllegalArgumentException();
    }

    public static void functio2()throws ClassNotFoundException{
        throw new ClassNotFoundException();
    }
}
