package com.zbn.springcloud.controller;

/**
 * @ClassName MyTest
 * @description: 线程学习
 * @author: zbn
 * @Date 2021/3/27 11:21
 **/
public class MyTest  {
    private  Integer number = 1;


    public synchronized void Ap()  {
        notify();
        if (number < 20){
            number ++;
            System.out.println(Thread.currentThread().getName()+"   生产第  " + number);
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void Bp()  {
        if (number > 0){
            notify();
            number --;
            System.out.println(Thread.currentThread().getName()+"         消费第  " + number);
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        MyTest myTest = new MyTest();
//        Thread t1 = new Thread(myTest);
//        Thread t2 = new Thread(myTest);
//        Thread t3 = new Thread(myTest);
//        t1.setName("甲");
//        t2.setName("乙");
//        t3.setName("丙");
//        t1.start();
//        t2.start();
//        t3.start();


        /**
         * 生产者消费者Main
         */
        MyTest c = new MyTest();
        A a = new A(c);
        a.setName("生产");
        B b = new B(c);
        b.setName("消费");
        a.start();
        b.start();






    }
}


//    @Override
//    public  void run() {
//        synchronized (this){
//            for (int i = number; number <= 100; number++) {
//                notifyAll();
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"i  = " + number);
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }



/**
 * ==============================================生产者消费者例子============================================================
 */



/**
 * 消费者
 */
class B extends Thread {
    private MyTest clerk;

    public B(MyTest clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.Bp();
        }
    }

}





/**
 * 生产者
 */
class A extends Thread{
    private MyTest clerk;
    public A (MyTest clerk){
        this.clerk = clerk;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.Ap();
        }
    }
}




