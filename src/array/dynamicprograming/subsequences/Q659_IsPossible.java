package array.dynamicprograming.subsequences;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/4 11:27
 */

public class Q659_IsPossible {
    public boolean isPossible(int[] nums) {
        //1.建立两个Map,分别存储未使用数字和已经形成的连接的最后一个数
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        //2.将数组中的数计数存储到map2中
        for(int x: nums){
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }
        //3.遍历 数组看其是否能形成新的3个数的连接，若可以 则放入map2
        for (int x: nums) {
            int count = map1.getOrDefault(x, 0);
            if(count > 0){
                int lastNum = map2.getOrDefault(x - 1, 0);
                //容器中有此连接
                if(lastNum > 0){
                    map1.put(x, map1.getOrDefault(x, 0) - 1);
                    map2.put(x - 1, map2.getOrDefault(x - 1, 0) - 1);
                    map2.put(x, map2.getOrDefault(x, 0) + 1);
                }else{
                    //新建连接
                    int count1 = map1.getOrDefault(x + 1, 0);
                    int count2 = map1.getOrDefault(x + 2, 0);
                    if(count1 > 0 && count2 > 0){
                       map1.put(x, map1.getOrDefault(x, 0) - 1);
                       map1.put(x + 1, map1.getOrDefault(x + 1, 0) - 1);
                       map1.put(x + 2, map1.getOrDefault(x + 2, 0) - 1);
                       map2.put(x + 2, map2.getOrDefault(x + 2, 0) + 1);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }






    public boolean isPossible01(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> endMap = new HashMap<Integer, Integer>();
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0) + 1;
            countMap.put(x, count);
        }
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            if (count > 0) {
                int prevEndCount = endMap.getOrDefault(x - 1, 0);
                if (prevEndCount > 0) {
                    countMap.put(x, count - 1);
                    endMap.put(x - 1, prevEndCount - 1);
                    endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                } else {
                    int count1 = countMap.getOrDefault(x + 1, 0);
                    int count2 = countMap.getOrDefault(x + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        countMap.put(x, count - 1);
                        countMap.put(x + 1, count1 - 1);
                        countMap.put(x + 2, count2 - 1);
                        endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,5,5};
        Q659_IsPossible m =new Q659_IsPossible();
        m.isPossible(arr);
    }


}
