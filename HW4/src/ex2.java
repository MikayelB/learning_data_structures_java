public class ex2 {
    public static void main(String[] args) {
        SLLList<Integer> list = new SLLList<>();


        // add method
        // comments below are for debugging purposes please ignore them
        list.add(0, 4);
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println("-----------------");

        list.add(1, 9);
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println("-----------------");


        list.add(2, 5);
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println("-----------------");


        list.add(1, 3);
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));
//        System.out.println("-----------------");


        list.add(3, 99);
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));
//        System.out.println(list.get(4));
//        System.out.println("-----------------");

        list.add(4, 55);
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));
//        System.out.println(list.get(4));
//        System.out.println(list.get(5));
//        System.out.println("-----------------");


        list.add(5, 22);
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));
//        System.out.println(list.get(4));
//        System.out.println(list.get(5));
//        System.out.println(list.get(6));



        // get method
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println(list.get(6));




        // set method
        System.out.println("-----after Set method-----");
        list.set(3, 33);  // will print 99 if printed
        list.set(5, 11);  // will print 22 if printed

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));


        // remove method
        System.out.println("-----after Remove method-----");

        list.remove(2); // will print 9 if printed
        list.remove(4); // will print 11 if printed

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

    }
}
