package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/6 14:32
 */

public class Q118_Generate {
    /**
     * 生成杨辉三角
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int num = 1;
        //1.存储上一层的数字
        List<Integer> last = new ArrayList<Integer>();
        while(num <= numRows){
            //2.填充本层数字
            List<Integer> cur = new ArrayList<Integer>(num);
            if(last.size() == 0){
                cur.add(1);
                last = cur;
            }else{
                int index = 0;
                while (index < num){
                    int tempLast = 0;
                    int temp = 0;
                    if(index - 1 >= 0){ tempLast = last.get(index - 1);}
                    if(index < num -1){
                        int i = last.get(index);
                        System.out.println(i);
                        temp = i;
                    }
                    cur.add(tempLast + temp);
                    index++;
                }
                last = cur;
            }
            num++;
            res.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        Q118_Generate m = new Q118_Generate();
        m.generate(5);
    }
}
