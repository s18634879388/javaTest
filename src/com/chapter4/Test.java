package com.chapter4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/3/8.
 */
public class Test {
    public long previous;
    public static void main(String[] args) {
        String s = new Test().generateToken("96e79218965eb72c92a549dd5a330112",true);
        System.out.println(s);
    }
    public synchronized String generateToken(String msg, boolean timeChange) {

        try {

            long current = System.currentTimeMillis();
            if (current == previous)                current++;
            previous = current;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(msg.getBytes());
            if (timeChange) {
                // byte now[] = (current+"").toString().getBytes();
                byte now[] = (new Long(current)).toString().getBytes();
                md.update(now);
            }
            return toHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    private String toHex(byte buffer[]) {
        StringBuffer sb = new StringBuffer(buffer.length * 2);
        for (int i = 0; i < buffer.length; i++) {
            sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));
            sb.append(Character.forDigit(buffer[i] & 15, 16));
        }

        return sb.toString();
    }
}
