import java.util.*;

public class DP1_Fibonacci_Recursive{
    public static int fib(int n){
        if(n <= 1){
            return 0;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args){
        int n = 5;
        System.out.println(fib(n));
    } 
}