package multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/18 12:26
 */

public class MyThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedPool = Executors.newFixedThreadPool(5);
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        ExecutorService singlePool = Executors.newSingleThreadExecutor();


    }
}
