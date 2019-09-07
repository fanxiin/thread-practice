package pers.xin.a;

public class WelcomeApp {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        System.out.printf("this is %s.%n", Thread.currentThread().getName());
        thread.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.printf("this is %s.%n", Thread.currentThread().getName());
    }
}
