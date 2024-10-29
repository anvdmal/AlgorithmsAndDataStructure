package org.example.stack;

//{[()}
public class StackCheck {
    public static boolean isValid(String input) {
        StackRealization<Character> stack = new StackRealization<>(input.length());
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                stack.pop();
            } else return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String inputNO = "{[()}";
        System.out.println("строка 1: " + inputNO);
        if (isValid(inputNO)) System.out.println("YES :)");
        else System.out.println("NO :(");

        String inputYES = "{[()]}";
        System.out.println("\nстрока 2: " + inputYES);
        if (isValid(inputYES)) System.out.println("YES :)");
        else System.out.println("NO :(");
    }
}
