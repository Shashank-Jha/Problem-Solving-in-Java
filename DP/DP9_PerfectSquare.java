public class DP9_PerfectSquare {
    class Solution {
    
        public int solveRec(int n){
            if(n == 0)return 0;
            int ans = Integer.MAX_VALUE;
            for(int i=1; i*i <= n ;i++){
                ans = Math.min(ans,solveRec(n-i*i)+1);
            }
            return ans;
        }
        
        public int solveMemo(int n,int[] dp){
            if(n == 0)return 0;
            if(dp[n] != Integer.MAX_VALUE)return dp[n];
            int ans = Integer.MAX_VALUE;
            for(int i=1; i*i <= n ;i++){
                ans = Math.min(ans,solveMemo(n-i*i,dp)+1);
            }
            dp[n] = ans;
            return dp[n];
        }
        
        public int solveTab(int n){
            int[] dp = new int[n+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;
            dp[1] = 1;
        for(int idx=2;idx<=n;idx++)
            for(int i=1;i*i<=idx;i++){
                dp[idx] = Math.min(dp[idx],dp[idx-i*i]+1); 
            }
            return dp[n];
        }
        
        public int numSquares(int n) {
            return solveTab(n);
        }
    }
}
