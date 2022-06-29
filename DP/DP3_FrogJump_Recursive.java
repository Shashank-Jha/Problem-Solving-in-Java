
public class DP3_FrogJump_Recursive {
    
    public static int frogJumpRec(int i,int n, int[] heights){
        if(i == 0) return 0;
        
        int singleJump = frogJumpRec(i-1,n,heights) 
        + Math.abs(heights[i]-heights[i-1]);
        int doubleJump=Integer.MAX_VALUE;
        if(i > 1)
        doubleJump = frogJumpRec(i-2,n,heights) + Math.abs(heights[i]-heights[i-2]);
        
        return Math.min(singleJump,doubleJump);
        
        
    }
    
    public static int frogJump(int n, int heights[]) {
        
        return frogJumpRec(n-1,n,heights); 
        
    }

}