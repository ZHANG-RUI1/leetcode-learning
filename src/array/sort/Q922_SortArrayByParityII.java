package array.sort;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/12 12:04
 */

public class Q922_SortArrayByParityII {
    /**
     * 原数组不变
     * @param A 待排序数组
     * @return 返回结果
     */
    public int[] sortArrayByParity02(int[] A) {
        //1.第一个偶数放第一位
        int[] B = new int[A.length];
        //j 的位置 j*2 k的位置为k*2 + 1
        for(int i = 0, j = 0, k = 0; i < A.length;i++){
            //临时保存当前数据
            int temp = A[i];
            if(A[i] % 2 == 0){
                B[j * 2] = temp;
                j++;
            }else{
                B[k * 2 + 1] = temp;
                k++;
            }
        }
        return B;
    }

    /**
     * 修改原数组
     * @param A 待排序数组
     * @return 返回结果
     */
    public int[] sortArrayByParity020(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if(A[i] % 2 == 1){
                while(A[j] % 2 == 1){
                    j += 2;
                }
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        return A;

    }
}
