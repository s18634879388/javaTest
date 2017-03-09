package com.saltMd5;

/**
 * Created by Administrator on 2017/3/9.
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "111112";
        String s2 = Md5Utils.md5(s1);
        System.out.println("加密后密码s2:"+s2);

        String s3 = Md5Utils.md5(s2);
        System.out.println("解密后密码s3:"+s3);

        String s4 = Md5Utils.md5(Md5Utils.md5(s2));
        System.out.println("解密后再加密密码s2："+s4);


    }
}
