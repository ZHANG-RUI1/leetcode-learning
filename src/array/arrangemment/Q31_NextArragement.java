package array.arrangemment;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/11 21:26
 */

public class Q31_NextArragement {
    public void nextPermutation(int[] nums) {
        //1.从数组的后面开始遍历，寻找nums[i] < nums[i+1]
        int i = nums.length - 2;
        for(; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                break;
            }
        }
        //2.从后向前遍历数组，寻找第一个大于i位置的值，交换。
        for(int j = nums.length - 1; j > i && i >= 0; j--){
            if(nums[j] > nums[i]){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        //3.将i+1到n的数升序排列
        int k = nums.length - 1;
        i++;
        while(i <= k){
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
            i++;
            k--;
        }
    }
}
