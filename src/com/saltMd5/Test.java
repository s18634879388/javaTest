package com.saltMd5;

/**
 * Created by Administrator on 2017/3/9.
 */
public class Test {
    public static void main(String[] args) {
        /*String s1 = "111112";
        String s2 = Md5Utils.md5(s1);
        System.out.println("加密后密码s2:"+s2);

        String s3 = Md5Utils.md5(s2);
        System.out.println("解密后密码s3:"+s3);

        String s4 = Md5Utils.md5(Md5Utils.md5(s2));
        System.out.println("解密后再加密密码s2："+s4);

        System.out.println(Md5Utils.md5(s4));
        String sout = Md5Utils.getNextSalt();
        System.out.println("salt:"+sout);

        System.out.println(Md5Utils.md5(Md5Utils.md5(s1)+sout));*/

        // MD5是不可逆的
        // MD5加密后应当再加上盐值进行二次加密
        // 当数据库泄露时，加盐和普通MD5都相当于不加密，所以加盐的意义在于不容易轻易的计算出MD5后的密码

        //bug修复

    }
}
