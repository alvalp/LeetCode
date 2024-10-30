package org.alvin.util;

public class SimpleBitMap {
    private static final int BIT_COUNT = 8;

    /**
     * bit 的位数，也就是设置value的最大值
     */
    private int count;

    /**
     * 位图的具体数据， 一个byte 可以存放8位。如果是long 则更大
     */
    private byte[] data;

    public SimpleBitMap(int count) {
        this.count = count;
        int length = (count + BIT_COUNT - 1) / BIT_COUNT;
        data = new byte[length];
    }

    public void set(int value) {
        if (value < 0 || value > count) {
            throw new IllegalArgumentException();
        }

        int index = value / BIT_COUNT;
        long byteIndex = value % BIT_COUNT;
        data[index] = (byte) ((1 << byteIndex) | data[index]);
    }

    public boolean contains(int value) {
        if (value < 0 || value > count) {
            return false;
        }
        int index = value / BIT_COUNT;
        long byteIndex = value % BIT_COUNT;

        // 需要和0判断， 不同的位置上的值是不一样的。
        return (data[index] & (1 << byteIndex)) != 0;
    }

    public static void main(String[] args) {
        SimpleBitMap simpleBitMap = new SimpleBitMap(1000000);
        simpleBitMap.set(9999);
        simpleBitMap.set(1);
        System.out.println(simpleBitMap.contains(1));
        System.out.println(simpleBitMap.contains(10));
        System.out.println(simpleBitMap.contains(9999));
    }
}
