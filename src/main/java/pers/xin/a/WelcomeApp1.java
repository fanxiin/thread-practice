package pers.xin.a;

public class WelcomeApp1 {
    public static void main(String[] args) {
        Thread myThread = new Thread(new MyRunnable());
        myThread.start();
        System.out.println("this is " + Thread.currentThread().getName() + ".");
        myThread.start();
    }
}

class MyRunnable implements Runnable{

    public void run() {
        System.out.printf("this is %s.\n", Thread.currentThread().getName());
    }
}