package array.dynamicprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/11 22:33
 */

public class Q514_findRotateSteps {
    public int findRotateSteps(String ring, String key){
        int n = ring.length(), m = key.length();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<Integer>();
        }
        //1.维护一个ring中字母的索引
        for (int i = 0; i < n; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        //2.初始化dp表
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; ++i){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        //3.以可以匹配的字符为j，向dp表中填入初始数据
        for(int i: pos[key.charAt(0) - 'a']){
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        //4.开始使用状态方程填充dp
        //状态方程：dp[i][j] = min(dp[i-1][k] + min(abs(j - k), n - abs(j - k))  + 1)
        for (int i = 1; i < m; i++) {
            for (int j: pos[key.charAt(i) - 'a']) {
                for(int k: pos[key.charAt(i - 1) - 'a']){
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }

        }


        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

}
