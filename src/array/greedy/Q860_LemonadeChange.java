package array.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/10 20:54
 */

public class Q860_LemonadeChange {
    /**
     * 贪心
     * 使用变量改进零钱罐
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        //1.使用Map存储要找的钱
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5){
                five++;
            } else if (bills[i] == 10){
                //2.有5找5加10，没5返回false
                if(five > 0){
                    five--;
                    ten++;
                } else {
                    return false;
                }
            }else if(bills[i] == 20){
                //2.有10有5找10+5，
                if(ten > 0 && five > 0){
                    five--;
                    ten--;
                } else if (five >= 3){
                    //只有5就找3个5
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange01(int[] bills) {
        //1.使用Map存储要找的钱
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(5, 0);
        map.put(10, 0);
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5){
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bills[i] == 10){
                //2.有5找5加10，没5返回false
                if(map.get(5) > 0){
                    map.put(5, map.getOrDefault(5, 0) - 1);
                    map.put(10, map.getOrDefault(10, 0) + 1);
                } else {
                    return false;
                }
            }else if(bills[i] == 20){
                //2.有10有5找10+5，
                if(map.get(10) > 0 && map.get(5) > 0){
                    map.put(10, map.getOrDefault(10, 0) - 1);
                    map.put(5, map.getOrDefault(5, 0) - 1);
                } else if (map.get(5) >= 3){
                    //只有5就找3个5
                    map.put(5, map.getOrDefault(5, 0) - 3);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
