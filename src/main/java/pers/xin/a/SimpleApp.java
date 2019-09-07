package pers.xin.a;

import java.util.Date;

public class SimpleApp {
    public static void main(String[] args) throws InterruptedException {
        while(true){
            System.out.println(new Date());
            Thread.sleep(1000);
        }
    }
}
