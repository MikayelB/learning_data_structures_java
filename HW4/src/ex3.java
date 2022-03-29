import java.util.Iterator;

public class ex3 {
    public static void main(String[] args) {
        SLLList<Integer> list = new SLLList<>();

        list.add(0, 0);
        list.add(1, 1);
        list.add(2, 2);
        list.add(3, 3);
        list.add(4, 4);
        list.add(5, 5);
        list.add(6, 6);
        list.add(7, 7);
        list.add(8, 8);


        Iterator<Integer> listIter = list.iterator();

        for(int i : list){
            System.out.println(i);
        }

    }
}
