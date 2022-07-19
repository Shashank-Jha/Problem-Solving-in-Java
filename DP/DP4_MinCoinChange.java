public class DP4_MinCoinChange {
    class Solution {
    
        public int solveMem(int[] coins, int amount, int[] dp){
            
            if(amount == 0){
                return 0;
            }
            
            if(amount < 0){
                return Integer.MAX_VALUE;
            }
            
            if(dp[amount] != -1){
                return dp[amount];
            }
            
            int min = Integer.MAX_VALUE;
            for(int e : coins){
                int ans = solveMem(coins,amount-e,dp);
                if(ans != Integer.MAX_VALUE)
                    min = Math.min(ans+1,min);
               
            }
            dp[amount] = min;
            return min;
            
        }
        
        public int coinChange(int[] coins, int amount) {
            // int[] dp = new int[amount+1];
            // for(int i=0;i<=amount;i++) dp[i] = -1;
            // int ans = solveMem(coins,amount,dp);
            // if(ans == Integer.MAX_VALUE) return -1;
            int ans = solveTab(coins,amount);
            return ans;
        }
        
        public int solveTab(int[] coins, int amount){
            int[] dp = new int[amount+1];
            for(int i=0;i<=amount;i++)dp[i] = Integer.MAX_VALUE;
            
            dp[0] = 0;
            for(int i = 1;i<=amount;i++)
            {
                for(int e : coins){
                    if(i-e >= 0 && dp[i-e] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i],1+dp[i-e]);
                }
            }
            if(dp[amount] == Integer.MAX_VALUE) return -1;
            else return dp[amount];
        }
    }
}
