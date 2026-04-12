package suffixExpression;

import stack.LinkedListStack;

public class SuffixExpression {
    public int calculate(String str){
        String[] tokens = str.split(" ");
        LinkedListStack stack = new LinkedListStack();
        for (String token : tokens){
            switch (token) {
                case "+" -> {
                    int count2 = (int) stack.pop();
                    int count1 = (int) stack.pop();
                    stack.pull(count1 + count2);
                }
                case "-" -> {
                    int count2 = (int) stack.pop();
                    int count1 = (int) stack.pop();
                    stack.pull(count1 - count2);
                }
                case "*" -> {
                    int count2 = (int) stack.pop();
                    int count1 = (int) stack.pop();
                    stack.pull(count1 * count2);
                }
                case "/" -> {
                    int count2 = (int) stack.pop();
                    int count1 = (int) stack.pop();
                    stack.pull(count1 / count2);
                }
                default -> stack.pull(Integer.parseInt(token));
            }
        }
        return (int) stack.pop();
    }
}
