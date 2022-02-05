import java.util.Scanner;
public class ex2 {

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the number of inputs:");

    int y = 0;
    int n = input.nextInt();

    System.out.println("Type ++y, y++, --y, or y-- based on what you want " + n + " times and click enter after each time: ");

    String[] inputsY = new String[n];
    for(int i = 0; i < n; i++){
        inputsY[i] = input.next();
    }

    for(int i = 0; i < n; i++){
        char sign = inputsY[i].charAt(1);
        int asciiNum = (int) sign;

        if (asciiNum != 43 && asciiNum != 45) {
            System.out.println("You didn't follow the instructions");
            return;
        } else{
            y += 1 - (asciiNum - 43);
        }

    }
    System.out.println("y = " + y);
    }
}
