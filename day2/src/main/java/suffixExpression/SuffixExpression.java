package suffixExpression;

import stack.LinkedListStack;
import validBrackets.ValidBrackets;

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

    public String advanceChange(String string){
        boolean check = ValidBrackets.check(string);
        if (!check) throw new RuntimeException("中缀表达式括号有误！");

        String[] tokens = string.split(" ");
        LinkedListStack stack = new LinkedListStack();
        StringBuilder stringBuilder = new StringBuilder();
        for (String token :tokens){
            switch (token){
                case "+", "-", "*", "/"  -> {
                    while (privily(token) <= privily((String) stack.peek())){
                        stringBuilder.append(stack.pop()).append(" ");
                    }
                    stack.pull(token);
                }
                case "(" -> {
                    stack.pull("(");
                }
                case ")" -> {
                    while (!stack.peek().equals("(")){
                        stringBuilder.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                }
                case "[" -> {
                    stack.pull("[");
                }
                case "]" -> {
                    while (!stack.peek().equals("[")){
                        stringBuilder.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                }
                default -> stringBuilder.append(token).append(" ");
            }
        }
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop()).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public String myChange(String string){
        boolean check = ValidBrackets.check(string);
        if (!check) throw new RuntimeException("中缀表达式括号有误！");

        String[] tokens = string.split(" ");
        LinkedListStack stack = new LinkedListStack();
        StringBuilder stringBuilder = new StringBuilder();
        for (String token :tokens){
            switch (token){
                case "+" -> {
                    while (!(stack.isEmpty()) && !stack.peek().equals("(")){
                        stringBuilder.append(stack.pop()).append(" ");
                    }
                    stack.pull("+");
                }
                case "-" -> {
                    while (!(stack.isEmpty()) && !stack.peek().equals("(")){
                        stringBuilder.append(stack.pop()).append(" ");
                    }
                    stack.pull("-");
                }
                case "*" -> {
                    while (!stack.isEmpty() && !stack.peek().equals("(") && (stack.peek().equals("*") || stack.peek().equals("/"))){
                        stringBuilder.append(stack.pop()).append(" ");
                    }
                    stack.pull("*");
                }
                case "/" -> {
                    while (!stack.isEmpty() && !stack.peek().equals("(") && (stack.peek().equals("*") || stack.peek().equals("/"))){
                        stringBuilder.append(stack.pop()).append(" ");
                    }
                    stack.pull("/");
                }
                case "(" -> {
                    stack.pull("(");
                }
                case ")" -> {
                    while (!stack.peek().equals("(")){
                        stringBuilder.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                }
                default -> stringBuilder.append(token).append(" ");
            }
        }
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop()).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    private int privily(String string){
        if (string == null){
            return -1;
        }
        switch (string){
            case "+" :
            case "-" : return 1;
            case "*" :
            case "/" : return 2;
            case "(" :
            case "[" : return 0;
            default  : return -1;
        }
    }
}
