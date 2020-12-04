package array.greedy;

import java.util.Arrays;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/24 9:16
 */

public class Q452_FindMinArrowShots {
    /**
     * 用例：[[-2147483646,-2147483645],[2147483646,2147483647]]
     *      在使用Comparator时，切忌使用两整数相减的方式
     * 可用的两种比较方式：
     *      Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
     *      Arrays.sort(points, (a, b) -> a[1] < b[1]? -1: 1);
     * @param points 输入数组
     * @return 返回结果
     */
    private int findMinArrowShots(int[][] points) {
        if(points.length == 0){ return 0; }
        //1.为初始数组排序
        Arrays.sort(points, (a, b) -> a[1] < b[1]? -1: 1);
        int count = 1;
        int minRight = points[0][1];
        for (int[] balloon: points) {
            if(balloon[0] > minRight){
                count++;
                minRight = balloon[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] p = {{10,16},{2,8},{1,6},{7,12}};

    }
}
