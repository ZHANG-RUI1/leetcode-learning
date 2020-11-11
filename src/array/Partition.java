package array;

import java.util.Random;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/9 22:51
 */

public class Partition {
    static int partition2(int[] arr, int start, int end, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, end);
        int i = start, j = end;
        while (i < j) {
            while(i < j && arr[i] <= pivot){
                ++i;
            }
            while(i < j && arr[j] >= pivot){
                --j;
            }
            if(i < j){
                swap(arr, i, j);
            }
        }
        swap(arr, i, end);
        return i;
    }
    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
    private void swap(int[][] arr, int from, int to){
        int temp0= arr[from][0];
        int temp1= arr[from][1];
        arr[from][0] = arr[to][0];
        arr[from][1] = arr[to][1];
        arr[to][0] = temp0;
        arr[to][1] = temp1;
    }

    public void random_select(int[][] points, int left, int right, int K) {
        Random rand = new Random();
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1) {
            random_select(points, left, i - 1, K);
        } else if (K > i - left + 1) {
            random_select(points, i + 1, right, K - (i - left + 1));
        }
    }


}
