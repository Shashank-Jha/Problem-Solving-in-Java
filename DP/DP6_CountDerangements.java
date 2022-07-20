// CN - code studio problem
public class DP6_CountDerangements {
    static int mod = 1000000007;
    public static long solveRec(int n){
        if(n == 1) return 0;
        if(n == 2)return 1;
        
        return ((n-1)%mod * ((solveRec(n-2)%mod) + (solveRec(n-1)%mod))%mod) % mod;
   
    }
    
    public static long solveMemo(int n, long[] dp){
        if(n == 1) return 0;
        if(n == 2) return 1;
        dp[1] = 0;
        dp[2] = 1;
        
        if(dp[n] != -1) return dp[n];
        dp[n] = ((n-1)%mod * ((solveMemo(n-2,dp)%mod) + (solveMemo(n-1,dp)%mod))%mod) % mod;
        return dp[n];
    }
    
    public static long solveTab(int n){
        long[] dp = new long[n+1];
        if(n==1) return 0;
        if(n==2) return 1;
        dp[1] = 0;
        dp[2] = 1;
        
        for(int i=3;i<=n;i++){
            long first = dp[i-2]%mod;
            long second = dp[i-1]%mod;
            long sum =(first+second)%mod;
            dp[i] = ((i-1)%mod * sum)%mod;
        }
        return dp[n];
    }
    
	public static long countDerangement(int n) {
//         long[] dp = new long[n+1];
//         for(int i=0;i<=n;i++) dp[i] = -1;
		long ans = solveTab(n);
        return ans;
	}
}


