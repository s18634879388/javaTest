package com.chapter3;

import sun.misc.BASE64Encoder;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/1.
 */
public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        String password = "111111";
//        MessageDigest md5 = MessageDigest.getInstance("MD5");
//        BASE64Encoder base64Encoder = new BASE64Encoder();
//        String passwordMd5 = base64Encoder.encode(md5.digest(password.getBytes("UTF-8")));
//        System.out.println(passwordMd5+"...");
        new Test().toMD5("111111");
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());

    }
    public void toMD5(String plainText) {
        try {
            //生成实现指定摘要算法的 MessageDigest 对象。
            MessageDigest md = MessageDigest.getInstance("MD5");
            //使用指定的字节数组更新摘要。
            md.update(plainText.getBytes());
            //通过执行诸如填充之类的最终操作完成哈希计算。
            byte b[] = md.digest();
            //生成具体的md5密码到buf数组
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            System.out.println("32位: " + buf.toString());// 32位的加密
            System.out.println("16位: " + buf.toString().substring(8, 24));// 16位的加密，其实就是32位加密后的截取
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
