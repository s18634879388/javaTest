package com.saltMd5;

/**
 * Created by Administrator on 2017/5/3.
 * 多线程同步问题
 */
public class Test2 extends Thread{
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        ticket.setCount(30);
        Test2 test = new Test2();
        test.setTicket(ticket);
        Test2 test2 = new Test2();
        test2.setTicket(ticket);
        Test2 test3 = new Test2();
        test3.setTicket(ticket);
        test.start();
        test2.start();
        test3.start();
    }

    @Override
    public  void run() {
        for (int i = 0; i < 50; i++) {
            synchronized (this.getTicket()){
                if (this.getTicket().getCount()>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"----->"+this.getTicket().getCount());
                    this.getTicket().setCount(this.getTicket().getCount()-1);
                }
            }

        }
    }
}
class Ticket{
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
