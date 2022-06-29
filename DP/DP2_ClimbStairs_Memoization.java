public class DP2_ClimbStairs_Memoization{
    public int climbMem(int n,int[] dp){
        if(n==0 || n==1) return dp[n] = 1;
        
        if(dp[n] > -1) return dp[n];
        
        return dp[n] = climbMem(n-1,dp)+climbMem(n-2,dp);
    }
    
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climbMem(n, dp);
    }
}