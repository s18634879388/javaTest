package com.chapter1;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2017/2/14.
 */
public class AAA{

    private String name;
    private int age;
    public static String sex;


//    public AAA(String name){
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //    public static void main(String[] args) throws IOException, ScriptException {
//        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
//        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
//        ScriptContext scriptContext = scriptEngine.getContext();
//        scriptContext.setWriter(new FileWriter("D:\\ss.txt"));
//        scriptEngine.eval("print('hello word!');");
//    }

    public void test(String name){
        System.out.println("public method"+name);
    }

    private void test2(String name){
        System.out.println("private method"+name);
    }
}
