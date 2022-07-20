public class DP5_MaxCutSegment {
    public class Solution {
    
        public static int cutMemo(int n,int x, int y, int z,int[] dp){
            if(n==0)return 0;
            if(n < 0) return Integer.MIN_VALUE;
            
            if(dp[n] != Integer.MIN_VALUE) return dp[n];
            
            int cutX = cutMemo(n-x,x,y,z,dp)+1;
            int cutY = cutMemo(n-y,x,y,z,dp)+1;
            int cutZ = cutMemo(n-z,x,y,z,dp)+1;
            
            return dp[n] = Math.max(cutX,Math.max(cutY,cutZ));
        }
        
        public static int cutTab(int n, int x, int y, int z){
            int[] dp = new int[n+1];
            for(int i=0;i<=n;i++)dp[i] = -1;
            dp[0] = 0;
            for(int i=1;i<=n;i++){
                if(i-x >= 0 && dp[i-x] != -1)
                    dp[i] = Math.max(dp[i],dp[i-x] + 1);
                
                 if(i-y >= 0 && dp[i-y] != -1)
                    dp[i] = Math.max(dp[i],dp[i-y] + 1);
                
                 if(i-z >= 0 && dp[i-z] != -1)
                    dp[i] = Math.max(dp[i],dp[i-z] + 1);
            }
           return dp[n];
        }
        
        public static int cutSegments(int n, int x, int y, int z) {
    //         int[] dp = new int[n+1];
    //         for(int i=0;i<=n;i++)dp[i] = Integer.MIN_VALUE;
            int ans = cutTab(n,x,y,z);
            if(ans < 0) return 0;
            return ans;
        }
    }
}
