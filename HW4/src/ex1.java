import sources.ArrayList;

import java.lang.reflect.Array;

public class ex1 {

    public static void addMissingLettersArrayList(ArrayList<Character> list){
        int ascii = 122; // z

        for(int i = 0; i <= 25; i++){//z x

            if((int)list.get(i) == ascii){
                if(i == list.size() -1){
                    list.add(list.size(), ' ');
                }
                ascii--;
            }else {
                list.add(i, (char) ascii);
                ascii--;
            }
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<Character> l = new ArrayList<>();
        l.add(0, 'm');
        l.add(1, 'j');
        l.add(2, 'd');
        l.add(3, 'b');
        l.add(4, 'a');

        System.out.println(l);
        addMissingLettersArrayList(l);
        System.out.println(l);

    }

}
