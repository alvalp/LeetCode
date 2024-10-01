package org.alvin.util;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ArrayUtil {

    public static <T> T[] values(T... args) {
        return args;
    }

    public static <T> void consumer(T values[]) {
        for (T value : values) {
            System.out.println(value + ",");
        }
    }

    public static <T> T[] instance(Class<T> c, Integer size) {
        return (T[]) Array.newInstance(c, size);
    }


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Long[] instance = instance(Long.class, 10);
        instance[0] = 10L;
        consumer(instance);

        int a = 1;

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

        list.getClass().getMethod("add", Object.class).invoke(list, "asd");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
