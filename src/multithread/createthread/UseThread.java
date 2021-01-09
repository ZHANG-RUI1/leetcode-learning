package multithread.createthread;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/29 18:10
 */

public class UseThread {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                //要执行的任务
            }
        };
        t1.start();

    }
}
