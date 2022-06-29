public class DP2_ClimbStairs_Recursive{

    public int climbStairs(int n) {
        if(n==0 || n==1) return 1;
        
        int step1 = climbStairs(n-1);
        int step2 = climbStairs(n-2);
        
        return step1+step2;
    }

}