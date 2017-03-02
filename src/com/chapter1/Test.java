package com.chapter1;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/2/13.
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//        test(1,2,5,6);
//        test2();
//        AAA aaa =
//        AAA.class.getConstructor().newInstance();
//        reflect(aaa,"name","sss");
//
//        Field field = AAA.class.getDeclaredField("sex");
//        field.set(aaa,"nan");
//        System.out.println(aaa.sex);

//        System.out.println(aaa.getName());
        AAA aaa = AAA.class.getConstructor().newInstance();
        Method method = aaa.getClass().getDeclaredMethod("test",String.class);
        method.setAccessible(true);
        method.invoke(aaa,"test1");


    }

    public static void test(int ... a){
        for (int x:a
             ) {
            System.out.println(x);
        }
        System.out.println(a[2]);
    }

    public static void test2(){
        String x = "大";
        switch (x){
            case "大":
                System.out.println("boy");
                break;
            case "小" :
                System.out.println("girl");
                break;
            default:
                System.out.println("ox");
                break;
        }
    }

    public static void reflect(Object obj,String field,Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "set"+field.substring(0,1).toUpperCase()+field.substring(1);
        Class clazz = obj.getClass();
        Method method = clazz.getMethod(methodName,value.getClass());
        method.invoke(obj,value);
    }

}
