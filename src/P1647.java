/**
 * P1647: 秋叶收藏集
 * 题意：每次可以将一片树叶反转颜色，用最小的调整代价让字母ry的列表排成rrryyyrrr的顺序。
 * 题解：dp
 */
class P1647{
    public static void main(String[] args) {
        
    }
    static class Solution{
        public int minimumOperations(String leaves){
            int len = leaves.length();
            int[][] dp = new int[len][3];
            dp[0][0] =  leaves.charAt(0) == 'y' ? 1 : 0;
            dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
            for (int i = 1; i < len; ++i) {
                int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
                int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
                dp[i][0] = dp[i - 1][0] + isYellow;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + isRed;
                if (i >= 2) {
                    dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + isYellow;
                }
            }
            return dp[len - 1][2];
        }
    }
}