import java.util.*;

public class TribonacciSeries {
    static void tri(int n) {
        if (n == 0) {
            System.out.println(0);
            return;
        } else if (n == 1) {
            System.out.println(0 + " " + 1);
            return;
        } else if (n == 2) {
            System.out.println(0 + " " + 1 + " " + 1);
            return;
        }
        int a = 0, b = 1, c = 1, d;
        for (int i = 3; i < n; i++) {
            d = a + b + c;
            System.out.print(d + " ");
            a = b;
            b = c;
            c = d;
        }
    }
    
    // static int triRec(int n) {
    //     return 0;
    // }

    // static int triMemo(int n, int[] memo) {
    //     return 0;
    // }

    // static int triTab(int n) {
    //     return 0;
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter value of n: ");
        int n = sc.nextInt();
        sc.close();

        //simple code for printing tribonacci series till n
        System.out.print("simple code: "); 
        tri(n);
        // System.out.println();

        // //priting tribonacci series using simple recurssion till n
        // System.out.print("using recurssion: ");
        // for (int i = 0; i < n; i++) {
        //     System.out.print(triRec(i) + " ");
        // }
        // System.out.println();

        // //priting tribonacci series using memoization till n
        // System.out.print("using memoization: ");
        // int[] memo = new int[n];
        // Arrays.fill(memo, -1);
        // for (int i = 0; i < n; i++) {
        //     System.out.print(triMemo(i,memo) + " ");
        // }
        // System.out.println();

        // //priting tribonacci series using tabulation till n
        // System.out.print("using tabulation: "); 
        // for (int i = 0; i < n; i++) {
        //     System.out.print(triTab(i) + " ");
        // }
        // System.out.println();
    }
}