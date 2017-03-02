package com.chapter2;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by Administrator on 2017/2/28.
 */
public class Test {
    public static void main(String[] args) {
//        ByteInputStream is = new ByteInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(is);
        ByteBuffer byteBuffer = ByteBuffer.allocate(12);
        byteBuffer.putInt(1);
        byteBuffer.putInt(2);
        byteBuffer.putInt(3);
//        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(byteBuffer.getInt(0));
        System.out.println(byteBuffer.getInt(1));
        System.out.println(byteBuffer.getInt(2));
    }
}
