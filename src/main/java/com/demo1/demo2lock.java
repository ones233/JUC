package com.demo1;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo2lock {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                ticket.sale();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                ticket.sale();
            }
        },"B").start();
    }
}
class Ticket2{
    private int number = 5;

    Lock lock =new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "票，剩余的：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        }
}