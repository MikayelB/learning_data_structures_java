import sources.ArrayList;
import sources.LinkedPositionalList;

import java.lang.reflect.Array;

public class ex1 {

    public static void addMissingLettersArrayList(ArrayList<Character> arrList){  // O(n) more details in main
        int ascii = 122; // z

        for(int i = 0; i <= 25; i++){//z x

            if((int)arrList.get(i) == ascii){
                if(i == arrList.size() -1){
                    arrList.add(arrList.size(), ' ');
                }
                ascii--;
            }else {
                arrList.add(i, (char) ascii);
                ascii--;
            }
        }
        arrList.remove(arrList.size() - 1);
    }

    public static void addMissingLettersLinkedPositionalList(LinkedPositionalList<Character> posList){

    }
    public static void main(String[] args) {
        ArrayList<Character> l = new ArrayList<>();
        l.add(0, 'm');
        l.add(1, 'j');
        l.add(2, 'd');
        l.add(3, 'b');
        l.add(4, 'a');

        System.out.println("ArrayList start: " + l);
        // O(n), more specifically O(26) since it has to loop through the arraylist and add the missing letters which are up to 26 letters
        addMissingLettersArrayList(l);
        System.out.println("ArrayList end: " + l);

    }

}
