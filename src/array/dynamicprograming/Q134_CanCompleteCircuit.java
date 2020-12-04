package array.dynamicprograming;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/18 22:52
 */

public class Q134_CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] dp = new int[n];
        //1.从每个加油站开始
        for(int i = 0; i < n; i++){
            for(int k = 0;k < n; k++){
                int j = k + i;
                if(j > n - 1){
                    j = j - n;
                }
                if(j < 0){
                    j = j + n;
                }
                if(k == 0){
                    dp[j] = gas[j] - cost[j];
                }else if(j == 0){
                    dp[j] = gas[j] - cost[j] + dp[j - 1 + n];
                }else{
                    dp[j] = gas[j] - cost[j] + dp[j - 1];
                }

                if(dp[j] < 0){
                    break;
                }

                if(k == n - 1){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {3,3,4};
        int[] cost = {3,4,4};
        Q134_CanCompleteCircuit m = new Q134_CanCompleteCircuit();
        m.canCompleteCircuit(gas, cost);
    }

}
