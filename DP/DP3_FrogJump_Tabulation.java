import java.util.*;
public class DP3_FrogJump_Tabulation  {
    
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int singleJump = dp[i-1]+ Math.abs(heights[i]-heights[i-1]);
            int doubleJump=Integer.MAX_VALUE;
            if(i > 1)
                doubleJump =dp[i-2] + Math.abs(heights[i]-heights[i-2]);
            
                dp[i] = Math.min(singleJump,doubleJump);
        }
        
        return dp[n-1]; 
        
    }

}
