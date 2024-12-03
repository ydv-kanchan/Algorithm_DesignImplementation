// package GreedyAlgo;
// import java.util.*;

// public class ActivitySelection {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[][] arr = new int[n][2];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < 2; j++) {
//                 arr[i][j] = sc.nextInt();
//             }
//         }
//         Arrays.sort(arr, Comparator.comparingInt(a -> a[1])); //to sort 2D array according to the 1st element in each row

//         int[][] result = new int[][];
//         result[0][0] = arr[0][0]; //initalise first element with arr's first element

//         for (int i = 1; i < n; i++) { //for rows
//             for (int j = 0; j < 2; j++) { //for columns
//                 for (int k = 0; k < n; k++) {
//                     System.out.print("result is "+ result[j][k] + " arr is " + arr[i][j]+" ");
//                 }
//             }
//             System.out.println();
//         }

//         // for (int i = 0; i < n; i++) {
//         //     for (int j = 0; j < 2; j++) {
//         //         System.out.print(arr[i][j] + " ");
//         //     }
//         //     System.out.println(); 
//         // }
//         sc.close();
//     }
// }