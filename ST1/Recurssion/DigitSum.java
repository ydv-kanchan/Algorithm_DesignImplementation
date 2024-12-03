import java.util.*;
class Main{
    public static int digitSum(int n){
      int originalN = n;
      if (n == 0) return 0; // Base case: if n becomes 0, return 0
      // Use absolute value of n for handling digits
      //return Math.abs(n % 10) + digitSum(n / 10);
      if(originalN>0) return (n%10) + digitSum(n/10);
      else return -n(n%10) + digitSum(n/10)
    }
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      while(n>0){
        int num = sc.nextInt(); // input number for which digit sum needs to be calculated
        int sum = digitSum(num);
        // If the number is negative, make the sum negative
        //System.out.println(num < 0 ? -sum : sum);
        System.out.println(sum);
        n--;
      }
      sc.close();
    }
}