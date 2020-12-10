package array.doubleindex;

import java.util.LinkedList;

/**
 * 积水量 = min(左边最大值,右边最大值)-当前值
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/7 23:14
 */

public class Q42_Trap {
    /**
     * 最优版，采用双指针法,维护左最大值，和右最大值两个数据
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while(left <= right){
            if(rightMax > leftMax){
                //1.当前左索引处的值大于原左最大值
                if(height[left] > leftMax){
                    leftMax = height[left];
                }else {
                     res += leftMax - height[left];
                }
                left++;
            }else{
                //2.当右索引处的值大于右最大值
                if(height[right] > rightMax){
                    rightMax = height[right];
                }else{
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }


    /**
     * 维护一个单调递减栈(只需遍历一次)
     * @param height
     * @return
     */
    public int trap02(int[] height) {
        //1.栈中加入数组元素的索引
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int res = 0;
        int i = 0;
        while(i < height.length){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                //1.需要计算的洼地高度索引
                int valIndex = stack.pop();
                if(stack.isEmpty()){ break; }
                //2.需要计算的宽度
                int dis = i - stack.peek() - 1;
                res += (Math.min(height[i], height[stack.peek()]) - height[valIndex]) * dis;
            }
            stack.push(i++);
        }
        return  res;

    }
    /**
     * 动态规划解法：
     *
     * @param height 高度数组
     * @return 水量
     */
    public int trap01(int[] height) {
        if(height == null || height.length == 0){ return 0; }
        int n = height.length;
        int res = 0;
        int[] maxl = new int[n];
        int[] maxr = new int[n];
        //1.填充左右最大值数组
        maxl[0] = height[0];
        for (int i = 1; i < n; i++){
            maxl[i] = Math.max(maxl[i-1], height[i]);
        }
        maxr[n - 1] = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            maxr[i] = Math.max(maxr[i + 1], height[i]);
        }
        //2.累加结果
        for (int i = 0; i < n; i++) {
            res += Math.min(maxl[i], maxr[i]) - height[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1,0,0,1};
        Q42_Trap m = new Q42_Trap();


    }

}
