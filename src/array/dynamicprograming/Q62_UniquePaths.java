package array.dynamicprograming;

import java.util.Arrays;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/9 21:27
 */

public class Q62_UniquePaths {
    /**
     * 最优：使用组合公式 C(r,n) = n!/(r! * (n-r)!)
     *      分析：总的步数为n 即题目中的m+n-2; r为m-1
     *      计算：(m+n-2)!/((n-1)*(m-1)) == (m+n-2)...(n)/(m-1)!
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n){
        int x = m - 1;
        int N = m + n - 2;
        long res = 1;
        for (int i = n, j = 1; i <= N ; i++, j++) {
            res = res * i / j;
        }
        return (int) res;
    }
    /**
     * 动态规划优化存储
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths03(int m, int n){
        int[] dp = new int[n];
        //1.先初始化数组
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[n-1];
    }


    /**
     * 使用动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths02(int m, int n){
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0){ dp[i][j] = 1; }
                else {
                    //状态方称：dp[i][j] = dp[i-1][j] + dp[i][j-1]
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 暴力逐个遍历，超出时间限制
     */
    int res = 0;
    public int uniquePaths01(int m, int n) {
        if(n == 0 && m == 0){ return 0; }
        if(n == 0 || m == 0){ return 1; }
        //先向下
        if(m > 1){
            uniquePaths01(m - 1, n);
        }
        if(n > 1){
            //再向右
            uniquePaths01(m, n - 1);
        }
        //已经到达右下方
        if(n == 1 && m == 1){
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Q62_UniquePaths m = new Q62_UniquePaths();
        m.uniquePaths(3, 3);
    }
}
