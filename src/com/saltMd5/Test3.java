package com.saltMd5;

/**
 * Created by Administrator on 2017/5/3.
 */
public class Test3 implements Runnable{
    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.setMoney(30);
        Test3 t1 = new Test3();
        t1.setBank(bank);
        Thread thread = new Thread(t1,"A");
        Thread thread2 = new Thread(t1,"B");
        thread.start();
        thread2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized (this){

                this.getBank().setMoney(this.getBank().getMoney()-1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.getBank().getMoney()>0){
//                synchronized (this.getBank()){
//
//                }
                    System.out.println(Thread.currentThread().getName()+"---剩余--->"+this.getBank().getMoney());
                }
            }


        }
    }
}
class Bank{
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
