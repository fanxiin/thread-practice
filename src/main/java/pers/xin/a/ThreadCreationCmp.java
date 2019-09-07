package pers.xin.a;

public class ThreadCreationCmp {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < 2 * cores; i++) {
            TestThread t = new TestThread();
            t.start();
        }

        TestRunnable tr = new TestRunnable();

        for (int i = 0; i < 2 * cores; i++) {
            Thread t = new Thread(tr);
            t.start();
        }

    }
    static class Counter{
        private int count = 0;

        public void increase(){
            count ++;
        }

        public int value(){
            return count;
        }
    }

    static class TestRunnable implements Runnable{
        private Counter c = new Counter();
        public void run() {
            for (int i = 0; i < 1000; i++) {
                c.increase();
            }
            System.out.println(Thread.currentThread().getName()+":"+c.value());
        }
    }

    static class TestThread extends Thread{
        Counter c = new Counter();
        @Override
        public void run(){

            for (int i = 0; i < 100; i++) {
                c.increase();
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+": "+c.value());
        }
    }
}

