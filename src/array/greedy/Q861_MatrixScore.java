package array.greedy;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/12/7 22:09
 */

public class Q861_MatrixScore {
    /**
     * 代码优化
     * @param A 接受矩阵
     * @return 结果
     */
    public int matrixScore02(int[][] A) {
        //1.统计行数
        int n = A.length;
        int m = A[0].length;
        int res = (1 << m - 1) * n;
        //2.不用真正的做行移动，先列后行统计每列的贡献值（除第一列），可以直接汇总贡献值
        for (int j = 1; j < m; j++){
            int val = 0;
            for (int i = 0; i < n; i++){
                if(A[i][0] == 0){
                    //模拟行移动时对于贡献值的影响
                    val += 1 - A[i][j];
                }else {
                    val += A[i][j];
                }
            }
            //需要列移动
            if(val < n / 2.0){ val = n - val; }
            res += (1 << m - j - 1) * val;
        }
        return res;
    }
    /**
     * 思路：贪心
     *       1.我们需要二维数组的每个内部数组的值最大，可以优先考虑将所有一维数组的最左端数字行移动为1
     *       2.然后对所有列中0的个数小于1的咧进行列移动
     */
    public int matrixScore(int[][] A) {

        //1.统计行数
        int n = A.length;
        int m = A[0].length;
        int[] vals = new int[m];
        int res = (1 << m - 1) * n;
        //2.进行初步的行移动
        for (int i = 0; i < n; i++){
            if(A[i][0] == 0){
                for (int j = 0; j < m; j++){
                    A[i][j] = Math.abs(A[i][j] - 1);
                }
            }
        }
        //3.统计每列的贡献值（除第一列）
        for (int i = 0; i < n; i++){
            for (int j = 1; j < m; j++){
                vals[j] += A[i][j];
            }
        }
        //4.汇总贡献值
        for(int i = 1;i < m; i++){
            double mid = n/2.0;
            int val = vals[i];
            //需要列移动
            if(val < mid){
                val = n - val;
            }
            res += (1 << m - i - 1) * val;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,1,0},{0,0,1}};
        Q861_MatrixScore m = new Q861_MatrixScore();
        m.matrixScore02(arr);
    }
}