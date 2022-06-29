import java.util.*;
public class DP3_FrogJump_Memoization  {
    
    public static int frogJumpRec(int i,int n, int[] heights,int[] dp){
        if(i == 0) return dp[i] = 0;
        if(dp[i] > -1) return dp[i];

        int singleJump = frogJumpRec(i-1,n,heights,dp) + Math.abs(heights[i]-heights[i-1]);
        int doubleJump=Integer.MAX_VALUE;

        if(i > 1)
        doubleJump = frogJumpRec(i-2,n,heights,dp) + Math.abs(heights[i]-heights[i-2]);
        
        return dp[i] = Math.min(singleJump,doubleJump);
        
    }
    
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return frogJumpRec(n-1,n,heights,dp); 
        
    }

}
