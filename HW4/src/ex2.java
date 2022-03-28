public class ex2 {
    public static void main(String[] args) {
        SLLList<Integer> list = new SLLList<>();


        // add method
        list.add(0, 4);
        list.add(1, 9);
        list.add(2, 5);
        list.add(1, 3);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));


//        System.out.println(list);
    }
}
