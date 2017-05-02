package com.saltMd5;

/**
 * Created by Administrator on 2017/5/2.
 */
public class Test1 implements Runnable{
    public int count;
    public static void main(String[] args) {
        Test1 t = new Test1();
        t.count=30;
        Thread thread = new Thread(t,"a");
        thread.start();
        Thread thread2 = new Thread(t,"b");
        thread2.start();
        Thread thread3 = new Thread(t,"c");
        thread3.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this){
                if (this.count>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"--->"+this.count);
                    this.count--;
                }

            }
        }
//        while (count>0){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"--->"+count);
//            count--;
//        }
    }
}
