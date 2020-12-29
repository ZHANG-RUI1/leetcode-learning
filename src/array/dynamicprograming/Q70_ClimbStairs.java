package array.dynamicprograming;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/10 22:59
 */

public class Q70_ClimbStairs {
    /**
     * 已经最优化
     * @param n 楼梯数
     * @return 方法数
     */
    public int climbStairs(int n) {
        //状态方称：dp[n]=dp[n-1]+dp[n-2]
        if(n < 3){ return n; }
        int dp = 0;
        int dp1 = 1;
        int dp2 = 2;
        for(int i = 3; i <=n; i++ ){
            dp = dp1 +  dp2;
            dp1 = dp2;
            dp2 = dp;
        }
        return dp;
    }
}
