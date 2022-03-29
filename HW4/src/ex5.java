import sources.LinkedPositionalList;
import sources.Position;

import java.util.Calendar;

public class ex5 {
    public static void main(String[] args) {


        LinkedPositionalList<Character> list = new LinkedPositionalList();

        list.addLast('c');
        list.addLast('d');
        list.addLast('z');
        list.addLast('h');
        list.addLast('e');
        list.addLast('a');

        System.out.println(list);
//        selectionSort(list);
        System.out.println(list);

    }

    public static void selectionSort(LinkedPositionalList<Character> PL){

        Position<Character> outerCurr = PL.first();
        Position<Character> first = PL.first();
            Position<Character> innerCurr = PL.first();
            Position<Character> min = PL.first();


        while(outerCurr != PL.last()) {

            while (innerCurr != null) {
                if (innerCurr.getElement() < min.getElement()) {
                    min = innerCurr;
                }
                innerCurr = PL.after(innerCurr);
            }
            innerCurr = outerCurr;

//            if (min == first) {
//                PL.after(outerCurr);
//                return;
//            }
            Position<Character> tempMin = min;
            char tempMinEl = tempMin.getElement();

//            PL.remove(min);
            PL.addBefore(outerCurr, PL.remove(min));

            System.out.println("====================");
            min = PL.after(outerCurr);
//            outerCurr = PL.after(outerCurr);
        }

    }
}
