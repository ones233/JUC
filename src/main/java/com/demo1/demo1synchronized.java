package com.demo1;



public class demo1synchronized {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

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
    class Ticket{
        private int number = 5;
        public synchronized void sale(){
            if(number>0){
        System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "票，剩余的：" + number);
        }
        }
}