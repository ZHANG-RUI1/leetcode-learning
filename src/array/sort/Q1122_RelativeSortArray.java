package array.sort;

import java.util.*;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/14 11:10
 */

public class Q1122_RelativeSortArray {
    /**
     * 题目：
     *      给你两个数组，arr1 和 arr2，arr2 中的元素各不相同
     *      arr2 中的每个元素都出现在 arr1 中
     *      对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
     *      未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     * @param arr1 输入数组1
     * @param arr2 输入数组2
     * @return 结果数组
     */
    public int[] relativeSortArray01(int[] arr1, int[] arr2) {
        //2.将arr2转换为ArrayList
        ArrayList<Integer> list = new ArrayList<>(arr2.length);
        for (Integer in: arr2) {
            list.add(in);
        }


        //3.Map存放数组中符合条件的元素，PriorityQue存放不符合条件的数
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i = 0; i < arr1.length; i++){
            if(!list.contains(arr1[i])){
                que.add(arr1[i]);
            }else if(map.containsKey(arr1[i])){
                map.replace(arr1[i], map.get(arr1[i]) + 1);
            }else{
                map.put(arr1[i], 1);
            }
        }
        //4.开始填充结果数组
        int k = 0;
        for(int i = 0; i < arr2.length && k < arr1.length; i++){
            if(map.containsKey(arr2[i])){
                int j = map.get(arr2[i]);
                while(j > 0){
                    arr1[k++] = arr2[i];
                    j--;
                }
                map.remove(arr2[i]);
            }
        }
        while(!que.isEmpty()){
            arr1[k++] = que.poll();
        }
        return arr1;
    }

    /**
     * 计数排序
     * @param arr1 输入数组1
     * @param arr2 输入数组2
     * @return 结果数组
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }



    public static void main(String[] args) {

        int[] arr1 ={2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        Q1122_RelativeSortArray m =new Q1122_RelativeSortArray();
        m.relativeSortArray(arr1, arr2);
    }
}
