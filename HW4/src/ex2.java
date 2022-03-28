public class ex2 {
    public static void main(String[] args) {
        SLLList<Integer> list = new SLLList<>();


        // add method
        list.add(0, 4);
        list.add(1, 9);
        list.add(2, 5);
        list.add(1, 3);
        list.add(3, 99);
        list.add(4, 55);
        list.add(5, 22);

        // get method
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));


        // set method
        System.out.println("-----after Set method-----");
        list.set(3, 33);
        list.set(5, 11);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));

//        System.out.println(list);
    }
}
