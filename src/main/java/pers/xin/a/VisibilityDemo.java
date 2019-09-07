package pers.xin.a;

public class VisibilityDemo {
    public static void main(String[] args) throws InterruptedException {
        TimeConsumingTask task = new TimeConsumingTask();
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(1000);
        task.cancel();
    }
}

class TimeConsumingTask implements Runnable{
    private boolean toCancel = false;
    public void run() {
        while (!toCancel){
            if(doExecute()){
                break;
            }
        }
        if (toCancel) {
            System.out.println("Task canceled");
        } else {
            System.out.println("Task done");
        }
    }

    private boolean doExecute(){
        boolean isDone = false;
        System.out.println("executing..");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isDone;
    }

    public void cancel() {
        toCancel = true;
        System.out.println(this + " canceled.");
    }
}
