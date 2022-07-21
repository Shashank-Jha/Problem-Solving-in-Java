public class DP7_01Knapsack {
    
public class Solution{
    
    static int solveRec(int[] weight, int[] value, int n, int capacity){
       
        if(n == 0){
            if(weight[0] <= capacity){
                return value[0];
            }else return 0;
        }
        int inc=0;
    if(weight[n] <= capacity)    
        inc = solveRec(weight,value,n-1,capacity - weight[n]) + value[n];
    int exc = solveRec(weight,value,n-1,capacity);
        
        return Math.max(inc,exc);
    }
    
    // Memoization 
    static int solveMemo(int[] weight, int[] value, int n, int capacity, int[][] dp){
       
        if(n == 0){
            if(weight[0] <= capacity){
                return value[0];
            }else return 0;
        }
        if(dp[n][capacity] != -1)return dp[n][capacity];
        int inc=0;
    if(weight[n] <= capacity)    
        inc = solveMemo(weight,value,n-1,capacity-weight[n],dp) + value[n];
    int exc = solveMemo(weight,value,n-1,capacity,dp);
        
        return dp[n][capacity] = Math.max(inc,exc);
    }
    // Tabulation with O(N*N) space
    static int solveTab(int[] weight, int[] value, int n, int capacity){
       int[][] dp = new int[n][capacity+1];
        
        
        for(int w=weight[0];w<=capacity;w++){
            if(weight[0] <= capacity)
               dp[0][w] = value[0];
            else dp[0][w] = 0;
        }
        
       for(int i=1;i<n;i++){
            for(int w=0;w<=capacity;w++){
                int inc=0;
                if(weight[i] <= w)
                   inc = dp[i-1][w-weight[i]] + value[i];
                int exc = dp[i-1][w];
                dp[i][w] = Math.max(inc,exc);
           }
       }
           return dp[n-1][capacity];
}

// Space Optimized : 2 arrays; O(2N)
static int solveTabOp(int[] weight, int[] value, int n, int capacity){
    int[][] dp = new int[n][capacity+1];
     int[] prev = new int[capacity+1];
     int[] curr = new int[capacity+1];
     
     
     for(int w=weight[0];w<=capacity;w++){
         if(weight[0] <= capacity)
            prev[w] = value[0];
         else prev[w] = 0;
     }
     
    for(int i=1;i<n;i++){
         for(int w=0;w<=capacity;w++){
             int inc=0;
             if(weight[i] <= w)
                inc = prev[w-weight[i]] + value[i];
             int exc = prev[w];
             curr[w] = Math.max(inc,exc);
        }
        prev = curr;
    }
        return prev[capacity];
}
    
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */
        
//         int[][] dp = new int[n+1][maxWeight+1];
//          for(int i=0;i<=n;i++){
//             for(int j=0;j<=maxWeight;j++){
//                 dp[i][j] = -1;
//             }
//          }
            return solveTab(weight,value,n,maxWeight);
        
    }
}
}
