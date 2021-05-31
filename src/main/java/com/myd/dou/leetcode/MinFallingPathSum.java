package com.myd.dou.leetcode;


/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/5/29 17:18
 * @Description: 931 最短路径求和 dp (Dynamic Programming)
 */
public class MinFallingPathSum {
    static int [][] matrix ={{2,1,3},{6,5,4},{7,8,9}};

    public static void main(String[] args) {

        final int ans = find(matrix);
        System.out.println(ans);

    }

    private static int find(int[][] matrix) {

        final int row = matrix.length;
        final int col = matrix[0].length;
        int[][]dp = new int[row][col];
        for(int j=0;j<col;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                if(j==0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j];
                }else if(j==col-1){
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j])+matrix[i][j];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1])+matrix[i][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j=0;j<col;j++){
            ans = Math.min(ans,dp[row-1][j]);
        }
        return ans;

    }
}
