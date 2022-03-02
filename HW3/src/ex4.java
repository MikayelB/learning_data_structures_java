public class Run {
    public static void main(String[] args) {

        StackDeque<Integer> stack = new StackDeque<Integer>();

        System.out.println("-------add first-------");
        stack.addFirst(5);
        System.out.println(stack);
        stack.addFirst(2);
        stack.addFirst(9);
        stack.printStackDeque();

        System.out.println("-------------Here was the full stack------------- \n");

        System.out.println("isEmpty function check: " + stack.isEmpty() + "\n");
        System.out.println("The result of function 'first': " + stack.first() + "\n");
        System.out.println("The result of function 'last': " + stack.last() + "\n");
        System.out.println("The result of function 'size': " + stack.size() + "\n");


        stack.removeFirst();
        System.out.println("-------removed first once-------");
        stack.printStackDeque();

        stack.removeFirst();
        System.out.println("-------removed first twice-------");

        stack.printStackDeque();
        stack.removeFirst();
        System.out.println("-------removed first three times-------");
        stack.printStackDeque();

        System.out.println("The result of function 'size': " + stack.size() + "\n");

        System.out.println("-------removed first 4 times (our stack had only 3 elements)-------");
        stack.removeFirst();
        stack.printStackDeque();

        System.out.println("-------------Here is the new full stack------------- \n");
        System.out.println("-------add last-------");
        System.out.println("---addLast(8) then addLast(20) then addLast(34)---");
        stack.addLast(8);
        stack.addLast(20);
        stack.addLast(34);
        stack.printStackDeque();

        System.out.println("The result of function 'size': " + stack.size() + "\n");

        System.out.println("-------remove last-------");
        System.out.println("---2 times removeLast()---");
        stack.removeLast();
        stack.removeLast();
        stack.printStackDeque();
    }
}
