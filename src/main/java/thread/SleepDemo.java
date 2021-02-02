package thread;

import java.util.Scanner;

/**
 * 线程提供的方法
 * static void sleep(long ms)
 * 该方法可以让运行这个方法的线程处于阻塞状态指定毫秒。超时后线程会自动
 * 回到RUNNABLE状态再次获取时间片并发运行。
 */
public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了..");
        /*
        完成一个倒计时程序，程序启动后要求用户输入一个数字。然后从该数字开始
        每秒递减，到0时提示时间到
         */
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int sec=scanner.nextInt();
        for (int i=sec;i>0;i--){
            try {
            Thread.sleep(1000);
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        System.out.println("时间到");
    }
}
