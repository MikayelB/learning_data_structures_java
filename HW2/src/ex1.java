import java.util.Scanner;
public class ex1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of minutes taking to reach your friend's house: ");
        int t = input.nextInt();

        System.out.println("Enter the number of your homework tasks: ");
        int n = input.nextInt();

        System.out.println("You have time to solve " + exerciseNumberCalculator(t, n) + " problems");
//        System.out.println(exerciseNumberCalculator(t, n));

    }
    // non-efficient version
/*

    public static int exerciseNumberCalculator(int t, int n){
        int totalMinutes = 240; // from 18:00 to 22:00 there are 4 hours which is 240 minutes
        totalMinutes -= t;
//        System.out.println("total minutes = " + totalMinutes);

        int sum = 0;
        int i = 1;

        while(sum + (5 * i) <= totalMinutes && i <= n){    // the i <= n condition is if the number of minutes is far more than required to finish the homework
            sum = sum + (5 * i);
//            System.out.println("problem = " + i);
//            System.out.println("sum = " + sum);
            i++;
        }

        return i - 1;     // i - 1 because by the end of the while loop, the i will be one more than we need

    }
*/

    // efficient version
    public static int exerciseNumberCalculator(int t, int n){
        int totalMinutes = 240 - t; // from 18:00 to 22:00 there are 4 hours which is 240 minutes
//        System.out.println("total minutes = " + totalMinutes);


        int resultNum = (int)((Math.sqrt(1 + (float)(8 * totalMinutes)/5) - 1)/2);  // the formula of finding n = [(-1 + sqrt(1+8t/5)]/2
        return Math.min(resultNum, n);
    }
}

