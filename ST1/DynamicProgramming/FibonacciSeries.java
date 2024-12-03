import java.util.*;

public class FibonacciSeries {

    //nth fibonacci number using recurssion
    static int fibRecurssion(int n) {
        if (n <= 1)
            return n;
        return fibRecurssion(n - 2) + fibRecurssion(n - 1);
    }
    
    //nth fibonacci number using DP memoization
    static int fibMemoization(int n, int[] memo) {
        if (n <= 1)
            return n;
        memo[n] = fibMemoization(n - 2, memo) + fibMemoization(n - 1, memo);
        return memo[n];
    }

    //nth fibonacci number using DP tabulation
    static int fibTabulation(int n) {
        if (n <= 1)
            return n;
        int[] tab = new int[n + 1];
        tab[0] = 0;
        tab[1] = 1;
        for (int i = 2; i <= n; i++) { //taking i<=n NOT i<n because the loop will iterate up to and including i = n.
            //If we stop at i < n (i.e., not including n), we wouldn’t compute the actual nth Fibonacci number, leaving tab[n] undefined or zero.
            tab[i] = tab[i - 2] + tab[i - 1];
        }
        return tab[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //printing fibonacii sereis till element n without using recurssion
        System.out.print("enter value of n: ");
        int n = sc.nextInt();
        int a = 0;
        int b = 1;
        int c;
        System.out.print("fibonacci series till " + n + " using simple method is: ");
        System.out.print(a+" "+ b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;

        }
        System.out.println();

        //printing fibonacci series till n using recurssion
        System.out.print("fibonacci series till n using recurssion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibRecurssion(i) + " ");
        }
        System.out.println();

        //fibonacci using memoization - storing only needed result in memo array
        int[] memo = new int[n+1];
        System.out.print("fibonacci series till n using memoization DP: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibMemoization(i, memo) + " ");
        }
        System.out.println();

        //fibonacci series using tabulation DP
        System.out.print("fibnoacci series using tabulation in DP: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibTabulation(i) + " ");
        }
        sc.close();
    }
}