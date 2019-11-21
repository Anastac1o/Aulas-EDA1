public class TesterClass {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack(20);

        //exercicio 2.1.1
        stack.push(23);
        stack.push(56);
        int b = stack.pop();
        int a = stack.pop();
        stack.push(a - b);

        stack.push(3);

        b = stack.pop();
        a = stack.pop();

        stack.push(a*b);
        stack.push(1);
        stack.push(3);
        stack.push(4);

        b = stack.pop();
        a = stack.pop();
        stack.push(a/b);
        b = stack.pop();
        a = stack.pop();
        stack.push(a+b);
        b = stack.pop();
        a = stack.pop();

        stack.push(a/b);
        System.out.println(stack.pop());

        //exercicio 2.1.2


        stack.push(2);
        stack.push(4);
        stack.push(7);
        stack.push(32);
        b = stack.pop();
        a = stack.pop();
        stack.push(a/b);
        b = stack.pop();
        a = stack.pop();
        stack.push(a + b);
        stack.push(7);
        stack.push(5);
        b = stack.pop();
        a = stack.pop();
        stack.push(a - b);
        stack.push(3);
        b = stack.pop();
        a = stack.pop();
        stack.push(a * b);
        b = stack.pop();
        a = stack.pop();
        stack.push(a - b);
        b = stack.pop();
        a = stack.pop();
        stack.push(a - b);

        System.out.println(stack.pop());

        //exercicio 2.1.3
        stack.push(2);
        stack.push(6);
        b = stack.pop();
        a = stack.pop();
        stack.push(a + b);
        stack.push(4);
        stack.push(7);
        b = stack.pop();
        a = stack.pop();
        stack.push(a * b);
        stack.push(5);
        b = stack.pop();
        a = stack.pop();
        stack.push(a - b);
        b = stack.pop();
        a = stack.pop();
        stack.push(a/b);
        stack.push(6);
        stack.push(9);
        b = stack.pop();
        a = stack.pop();
        stack.push(a/b);
        b = stack.pop();
        a = stack.pop();
        stack.push(a*b);
        stack.push(4);
        stack.push(9);
        b = stack.pop();
        a = stack.pop();
        stack.push(a*b);
        stack.push(5);
        stack.push(3);
        b = stack.pop();
        a = stack.pop();
        stack.push(a/b);
        b = stack.pop();
        a = stack.pop();
        stack.push(a+b);
        b = stack.pop();
        a = stack.pop();
        stack.push(a-b);

        System.out.println(stack.pop());


    }
}
