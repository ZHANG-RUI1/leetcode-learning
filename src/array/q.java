package array;

public class q {

    public int minimumEffortPath(int[][] heights) {
        return 0;
    }

    public void path(int[][] heights,int i, int j,boolean[][] mark,int min) {
        if(i == heights.length -1 && j == heights[0].length - 1){
            return;
        }
        mark[i][j] = true;
        int temp;
        //向上
        if(i > 0 && i <heights.length && !mark[i-1][j]){
            int dis = Math.abs(heights[i][j] - heights[i-1][j]);
            temp = dis < min? dis: min;
            path(heights,i-1,j,mark, temp);
        }
        //向右
        if(j > 0 && j <heights[0].length - 1  && !mark[i][j+1]){
            int dis = Math.abs(heights[i][j] - heights[i][j+1]);
            temp = dis < min? dis: min;
            path(heights,i,j+1,mark, temp);
        }
        //向下
        if(i > 0 && i < heights.length -1 && !mark[i+1][j]){
            int dis = Math.abs(heights[i][j] - heights[i+1][j]);
            temp = dis < min? dis: min;
            path(heights,i+1,j,mark, temp);
        }
        //向左
        if(j > 0 && j <heights[0].length && !mark[i][j-1]){
            int dis = Math.abs(heights[i][j] - heights[i][j-1]);
            temp = dis < min? dis: min;
            path(heights,i,j-1,mark, temp);
        }

    }
}
