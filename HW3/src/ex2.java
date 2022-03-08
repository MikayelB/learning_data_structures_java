import sources.ArrayList;

import java.lang.reflect.Array;
import java.util.Scanner;

public class ex2 {

    public static void fixInput(String text){
        //creating ArrayList
        ArrayList<Character> list = new ArrayList<Character>(text.length());

        char userInputArray[] = text.toCharArray();  // converting the string to character array

        // adding the characters to the ArrayList
        for(int i = 0; i < text.length(); i++){
            list.add(i, userInputArray[i]);
        }

//        System.out.println(list);  // the original string

        // function for fixing the string itself
        fixing(list);
        System.out.println(list);



    }

    // function for fixing the string itself
    private static void fixing(ArrayList al){
        for(int i = 0; i < al.size(); i++){
            // meant for al.get(i+1) to not cause error
            if(i == al.size() - 1) {
                return;
            } else {
                // the actual elimination process
                if(al.get(i) == al.get(i + 1)){
                    al.remove(i + 1);
                    al.remove(i);
                    fixing(al);
                }
            }
        }
    }


    public static void main(String[] args) {

        //-------input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the word to fix: ");

        String userInput = input.nextLine();
        //------------

        // calling the function to fix the string
        fixInput(userInput);


    }
}
