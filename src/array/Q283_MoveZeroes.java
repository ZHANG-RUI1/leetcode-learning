package array;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/19 21:59
 */

public class Q283_MoveZeroes {

    /**
     * 交换
     * @param nums 传入数组
     */
    public void moveZeroes02(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    /**
     * 填充
     * @param nums 传入数组
     */
    public void moveZeroes01(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                nums[i++] = nums[j];
            }
        }
        for(; i < nums.length; i++){
            nums[i] = 0;
        }
    }


}
