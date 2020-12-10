package array.greedy;

import java.util.*;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/5 22:50
 */

public class Q621_LeastInterval {
    /**
     * 任务调度：
     *      贪心h
     *      让数量最多的任务优先填充一个二维矩阵h行，n + 1列
     *      最大时间必然是：(n + 1) * h + Countmax(字符最多的数目) 或者 tasks.length
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int res = 0;
        //1.使用统计数组中的字符,存入新数组
        int[] counts = new int[26];
        for(Character ch: tasks){
            counts[ch - 'A']++;
        }

        PriorityQueue<Integer> que = new PriorityQueue<Integer>((a, b) -> b.compareTo(a));
        //2.将统计数组中的数移入que中
        for(int in: counts){
            if(in <= 0){ continue; }
            que.add(in);
        }
        //3.开始计数
        if(!que.isEmpty()){
            int max = que.peek();
            int maxCount = 0;
            while(!que.isEmpty() &&que.peek() == max){
                que.poll();
                maxCount++;
            }
            res = (max - 1) * (n + 1) + maxCount;
        }
        return Math.max(res, tasks.length);
    }
}
