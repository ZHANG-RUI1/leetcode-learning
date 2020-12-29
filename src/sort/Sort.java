package sort;

import java.util.Arrays;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/15 23:44
 */


public class Sort {
    /**
     * 1.快排
     * @param arr 原数组
     * @param left 最左指针
     * @param right 最右指针
     */
    public int[] quickSort(int[] arr, int left, int right){
        int mid = arr[(left + right)/2];
        int l = left;
        int r = right;

        while(r > l){
            //寻找左边大于mid的数
            while(arr[l] < mid){
                l++;
            }
            //寻找右边小于mid的数据
            while(arr[r] > mid){
                r--;
            }

            if(l >= r){
                break;
            }
            int temp = arr[l];
            arr[l] =arr[r];
            arr[r] = temp;

            if(arr[l] == mid){
                r--;
            }
            if(arr[r] == mid){
                l++;
            }
        }

        if(r == l){
            l++;
            r--;
        }
        if(left < r){
            quickSort(arr, left, r);
        }
        if(right > l){
            quickSort(arr, l, right);
        }
        return arr;
    }

    /**
     * 2.插排
     * @param arr 待排序数组
     * @return 已排序数组
     */
    public int[] insertSort02(int[] arr){
        for(int i = 1; i < arr.length; i++){
            //1.缓存需判断是否要插入的数据，并缓存此位数据的前一个数据的索引
            int temp = arr[i];
            int  j = i - 1;

            //2.判断是否需要插入该数据，若需要，依次向后挪移数据，直到找到那个需要插入数据的位置
            while(j >= 0 && temp < arr[j] ){
                arr[j + 1] = arr[j];
                j--;
            }
            //3.判断是否需要插入数据，j + 1 = i 意味着j没有改变，即本次循环没有需要插入的数据
            if(j + 1 != i){
                arr[j+1] = temp;
            }
        }
        return arr;
    }


    /**
     * 3.归并排序
     * @param arr 待排序数组
     * @param left 左索引
     * @param right 右索引
     * @param temp 额外空间
     * @return 返回排序好的数组
     */
    public int[] mergeSort(int[] arr, int left, int right, int[] temp){

        if(left < right){
            int mid = (right + left) / 2;
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            //合并左右有序序列
            merge(arr, left, mid, right, temp);
        }
        return arr;
    }

    /**
     * 合并同一数组的有序序列
     * @param arr 待排序数组
     * @param left 左索引
     * @param mid 中间索引
     * @param right 右索引
     * @param temp 额外空间
     * @return 返回合并排序好的数组
     */
    private int[] merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= right){
            temp[k++] = arr[j++];
        }

        int t = 0;
        while (t < k){
            arr[left + t] = temp[t];
            t++;
        }
        return arr;
    }

    /**
     * 4.计数排序（需要特定条件（较常用））
     * @param arr 输入数组
     * @param n 数据种类数，如：0~60
     */
    public void countSort(int arr[], int n){
        //1.填充计数数组
        int[] count = new int[n+1];
        for (int in: arr) {
            count[in]++;
        }
        int i = 0;
        //2.通过计数数组恢复数据
        for (int j = 0; j < count.length;j++) {
            while(count[j]-- > 0){
                arr[i++] = j;
            }
        }

    }













    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8, 11, 0, 5, 11, 2, 4, 7, 14,15};
        Sort s = new Sort();
        s.countSort(arr, 20);
        System.out.println(Arrays.toString(arr));


    }



}
