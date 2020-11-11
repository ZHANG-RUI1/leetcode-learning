package array;

import java.util.*;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/9 10:53
 */

public class Q973_KClosest {

    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        PriorityQueue<int[]> que = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double pos1 = Math.pow(o1[0], 2) + Math.pow(o1[1],2);
                double pos2 = Math.pow(o2[0], 2) + Math.pow(o2[1],2);
                if(pos1 > pos2){
                    return 1;
                }else if(pos1 < pos2){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        for (int i = 0; i < points.length; i++) {
            que.offer(points[i]);
        }
        int j = 0;
        while(!que.isEmpty()){
            if(j >= K){
                break;
            }
            res[j] = que.poll();
            j++;
        }
        return res;
    }

    /**
     * 解题失败
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest00(int[][] points, int K) {
        //1.定义结果数组
        //2.定义距离比较数组
        //3.
        int[][] res = new int[K][2];
        //使用结果补充集合，用于处理距离相同的情况
        List<Integer> list = new ArrayList<Integer>();

        Map<Double, Integer> map= new TreeMap<Double, Integer>();
        for(int i = 0; i < points.length; i++){
            double key = Math.pow(points[i][0], 2) + Math.pow(points[i][1],2);
            if(!map.containsKey(key)){
                map.put(key, i);
            }else{
                list.add(i);
            }

        }
        int j = 0;
        for(Map.Entry<Double, Integer> en: map.entrySet()){
            if(j >= K){
                break;
            }
            res[j][0] = points[en.getValue()][0];
            res[j][1] = points[en.getValue()][1];
            j++;
        }
        if(j < K){
            for(Integer in: list){
                if(j >= K){
                    break;
                }
                res[j][0] = points[in][0];
                res[j][1] = points[in][1];
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[] arr ={9, 7, 2, 4, 8, 1, 5, 3, -2, -1};

        //partition2(arr, 0, arr.length - 1, 3);


        int[][] arr1 = {{0, 1}, {1, 0}, {0, 0}};
        Q973_KClosest m = new Q973_KClosest();
        m.kClosest(arr1, 2);
    }
}
