public class ex5 {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(10);

        System.out.println("-----size-----");
        System.out.println(stack.size());

        System.out.println("-----isEmpty-----");
        System.out.println(stack.isEmpty());

        System.out.println("-----push-----");
        stack.push(2);
        stack.push(4);
        stack.push(3);
        System.out.println("push(2), push(4), push(3)");
        System.out.println("stack.size(): " + stack.size());
        System.out.println("The stack at the moment: " + stack);

        System.out.println("-----top-----");
        System.out.println(stack.top());


        stack.push(6);
        stack.push(123);
        stack.push(6123);
        System.out.println("push(6), push(123), push(6123)");
        System.out.println("The stack at the moment: " + stack);

        System.out.println("-----top-----");
        System.out.println(stack.top());

        System.out.println("stack.size(): " + stack.size());

        System.out.println("-----isEmpty-----");
        System.out.println(stack.isEmpty());

        System.out.println("-----pop-----");
        stack.pop();
        System.out.println("The stack at the moment: " + stack);

        System.out.println("-----top-----");
        System.out.println(stack.top());

        System.out.println("-----pop-----");
        stack.pop();
        System.out.println("The stack at the moment: " + stack);

        System.out.println("-----top-----");
        System.out.println(stack.top());
    }
}
