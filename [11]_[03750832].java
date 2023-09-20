import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(removeRepeated("abbcccdde"));
        System.out.println(removeRepeated("a"));

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(8);
        stack.push(9);
        stack.push(7);
        stack.push(5);
        stack.push(3);

        System.out.println(sizeDiff(stack, 3));
        System.out.println(sizeDiff(stack, 5));
        System.out.println(sizeDiff(stack, 7));

        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);
        stack1.push(8);

        System.out.println(sumProdAdj(stack1));

        Stack<Integer> s = new Stack<Integer>();
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);

        System.out.println(sumProdAdj(s));

    }

    // Homework 11.1: Recursion **
    public static String removeRepeated(String letters) {
        if (letters.length() < 2) {
            return letters;
        }
        char temp = letters.charAt(0);
        String shortened = letters.substring(1);

        if (temp == shortened.charAt(0)) {
            return removeRepeated(letters.substring(1));
        }
        return letters.charAt(0) + removeRepeated(letters.substring(1));
    }


    //Homework 11.2: Recursion **
    public static int sizeDiff(Stack<Integer> stack, int number) {
        if (stack.isEmpty()) {
            return number * -1;
        }
        int element = stack.pop();
        int diff = sizeDiff(stack, number);
        stack.push(element);
        return diff + 1;
    }

    //Homework 11.3: Recursion **
    public static int sumProdAdj(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return 0;
        }
        int first = stack.pop();
        if (stack.isEmpty()) {
            return 0;
        }
        int second = stack.pop();
        int sum = first * second + sumProdAdj(stack);
        stack.push(second);
        stack.push(first);
        return sum;
    }
}

