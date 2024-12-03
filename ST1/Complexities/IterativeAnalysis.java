package Complexities;
import java.util.*;

public class IterativeAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // constant time complexity O(1)
        int n = sc.nextInt(); // input an  integer
        int count = 0;
        // for (int i = 0; i < 10 /* any constant no. */; i++) {
        //     System.out.println(n + " print no. of times irrespective of input");
        //     count++;
        // }
        // System.out.println(count + " ");
        //for chechking the no. of times the loop is running which is equal to const you provied in the lopp condition

        // linear time O(n)
        // for (int i = 0; i < n; i++) {
        //     System.out.println("no. of times loop runs, depends on input provided!");
        //     count++; //will be equal to the n
        // }
        // System.out.println(count + " " + n);

        // for (int i = 0; i < n; i++) {
        //     System.out.println("outer loop");

        //     //only the number of times the inner loop will run will give the time complexity
        //     for (int j = 0; j < n; j++) {
        //         count++;
        //         System.out.println("inner loop");
        //     }
        // }
        // System.out.println(count+" " + n); //count will be n^2 

        // for (int i = 0; i < n; i++) {
        //     System.out.println("1st loop");

        //     //only the number of times the inner loop will run will give the time complexity
        //     for (int j = 0; j < n; j++) {
        //         System.out.println("2nd loop");
        //         for (int k = 0; k < n; k++) {
        //             count++;
        //             System.out.println("3rd loop");
        //         }
        //     }
        // }
        // System.out.println(count + " " + n); //count will be n^3
        
        // for (int i = 0; Math.pow(i,2) < n; i++) {
        //     count++;
        //     System.out.println("this loop is running root times");
        // }
        // System.out.println(count + " " + n); //count will be root(n)


        for (int i = 0; i < Math.pow(n, 2); i++) {
            System.out.println("loop ");
            count++;
        }
        System.out.println(count + " " + n); // TC in 
        sc.close();
    }
}
