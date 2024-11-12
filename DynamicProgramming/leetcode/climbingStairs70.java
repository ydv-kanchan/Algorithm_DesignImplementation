package DynamicProgramming.leetcode;
import java.util.*;
public class climbingStairs70 {
    static int climbStair(int n) {
        // using memoizatoion
        if (n == 1)
            return 1;
        
        //memoization array
        int[] memo = new int[n + 1];
        //storing the default climbing steps 
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int steps = sc.nextInt();
        System.out.println(climbStair(steps));
        sc.close();
    }
}