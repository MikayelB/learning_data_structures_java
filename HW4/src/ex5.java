import sources.LinkedPositionalList;
import sources.Position;

import java.util.Calendar;
import java.util.NoSuchElementException;

public class ex5 {
    public static void main(String[] args) {


        LinkedPositionalList<Character> list = new LinkedPositionalList();

        list.addLast('c');
        list.addLast('d');
        list.addLast('b');
        list.addLast('z');
        list.addLast('h');
        list.addLast('i');
        list.addLast('e');
        list.addLast('a');

        System.out.println(list);
//        selectionSort(list);
        bubbleSort(list);
        System.out.println(list);

    }

    // a)
    public static void selectionSort(LinkedPositionalList<Character> PL){
//  garbage
//
//
//        while(outerCurr != PL.last()) {
//
//            while (innerCurr != null) {
//                if (innerCurr.getElement() < min.getElement()) {
//                    min = innerCurr;
//                }
//                innerCurr = PL.after(innerCurr);
//            }
//            innerCurr = outerCurr;
//
////            if (min == first) {
////                PL.after(outerCurr);
////                return;
////            }
//            Position<Character> tempMin = min;
//            char tempMinEl = tempMin.getElement();
//
////            PL.remove(min);
//            PL.addBefore(outerCurr, PL.remove(min));
//
//            System.out.println("====================");
//            min = PL.after(outerCurr);
////            outerCurr = PL.after(outerCurr);
//        }

        Position<Character> outerCurr = PL.first();
        Position<Character> innerCurr = PL.first();
        Position<Character> min = PL.first();

        while(outerCurr != null) {
            while (innerCurr != null) {
                if (innerCurr.getElement() < min.getElement()) {
                    min = innerCurr;
                }
                innerCurr = PL.after(innerCurr);
            }

            if(min == outerCurr){
                outerCurr = PL.before(outerCurr);
                min = outerCurr;
                innerCurr = outerCurr;
                continue;
            }

            PL.addBefore(outerCurr, min.getElement());
            PL.addAfter(PL.before(min), outerCurr.getElement());
            PL.remove(min);
            outerCurr = PL.after(outerCurr);
            PL.remove(PL.before(outerCurr));
            min = outerCurr;
            innerCurr = outerCurr;
        }
    }

    public static void insertionSort(Position<Character> pos){

    }

    // c)
    public static void bubbleSort(LinkedPositionalList<Character> PL){
        Position<Character> outerCurr = PL.last();
        Position<Character> innerCurr = PL.last();
        Position<Character> max = PL.last();

        while(outerCurr != null) {
            while (innerCurr != null) {
                if (innerCurr.getElement() > max.getElement()) {
                    max = innerCurr;
                }
                innerCurr = PL.before(innerCurr);
            }

            if(max == outerCurr){
                outerCurr = PL.before(outerCurr);
                max = outerCurr;
                innerCurr = outerCurr;
                continue;
            }

            PL.addAfter(outerCurr, max.getElement());
            PL.remove(max);
            innerCurr = outerCurr;
            max = outerCurr;
            outerCurr = PL.before(outerCurr);
        }
    }

}
