package multithread.createthread;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/29 18:15
 */

public class UseRunnable {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //执行任务
            }
        };

        Thread t2 = new Thread(runnable, "t2");
        t2.start();

        //Java8lambda精简版
        Runnable runnable1 = () -> System.out.println("hello");
        Thread t3 = new Thread(runnable1, "t3");

    }
}
