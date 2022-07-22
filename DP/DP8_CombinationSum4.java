public class DP8_CombinationSum4 {
    class Solution {
    
        public int sumRec(int[] nums, int tar){
            if(tar == 0)return 1;
            if(tar < 0 )return 0;
            int ans=0;
            for(int e : nums){
                ans += sumRec(nums,tar-e);
            }
            return ans;
        }
        
        public int sumMemo(int[] nums, int tar, int[] dp){
            if(tar == 0)return 1;
            if(tar < 0 ){
                return 0;
            }
            if(dp[tar] != -1)return dp[tar];
            int ans=0;
            for(int e : nums){
                ans += sumMemo(nums,tar-e,dp);
            }
            return dp[tar] = ans;
        }
        
        public int sumTab(int[] nums, int tar){ 
            int[]dp = new int[tar+1];
            dp[0] = 1;

            for(int i=1; i<=tar ; i++)
            for(int e:nums){
                if(i-e >= 0)
                    dp[i] += dp[i-e];
            }
            return dp[tar];
        }
        
        public int combinationSum4(int[] nums, int target) {
            // int[] dp = new int[target+1];
            // Arrays.fill(dp,-1);
            return sumTab(nums,target);
        }
    }
}
