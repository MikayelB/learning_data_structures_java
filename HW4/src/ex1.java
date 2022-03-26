import sources.ArrayList;
import sources.LinkedPositionalList;
import sources.Position;

import javax.swing.*;

public class ex1 {

    // ArrayList way
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


    // LinkedPositionalList way
    public static void addMissingLettersLinkedPositionalList(LinkedPositionalList<Character> posList){
        int ascii = 122; // z
        Position<Character> curr = posList.first();
        Position<Character> temp  = null;

        for(int i = 0; i < 25; i++) {

            if(curr == posList.first()){
                posList.addBefore(curr, (char)ascii);
                ascii--;
            }

            if ((int) curr.getElement() < ascii) {
                posList.addBefore(curr, (char)ascii);
            } else if((int) curr.getElement() > ascii){
                posList.addAfter(curr, (char) ascii);
                curr = posList.after(curr);
            } else{
                if(curr == posList.last()){
                    posList.addAfter(curr, ' ');
                }
                curr = posList.after(curr);
            }
            ascii--;
        }
        posList.remove(curr);
    }

    public static void main(String[] args) {

        //---------------ArrayList way------------------
        ArrayList<Character> aList = new ArrayList<>();
        aList.add(0, 'm');
        aList.add(1, 'j');
        aList.add(2, 'd');
        aList.add(3, 'b');
        aList.add(4, 'a');

        System.out.println("ArrayList start: " + aList);
        // O(n), more specifically O(26) since it has to loop through the arraylist and add the missing letters which are up to 26 letters
        addMissingLettersArrayList(aList);
        System.out.println("ArrayList end: " + aList);

        //---------------LinkedPositionalList way------------------
        LinkedPositionalList<Character> pList = new LinkedPositionalList<>();
        pList.addLast('m');
        pList.addLast('j');
        pList.addLast('d');
        pList.addLast('b');
        pList.addLast('a');

        System.out.println("LinkedPositionalList start: " + pList);
        addMissingLettersLinkedPositionalList(pList);
        System.out.println("LinkedPositionalList end: " + pList);
    }
}
