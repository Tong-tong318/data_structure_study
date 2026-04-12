package validBrackets;

import stack.LinkedListStack;

public class ValidBrackets {
    public static boolean check(String str){
        LinkedListStack stack = new LinkedListStack();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '('){
                stack.pull(1);
            } else if (str.charAt(i) == '[') {
                stack.pull(2);
            } else if (str.charAt(i) == '{') {
                stack.pull(3);
            } else if (str.charAt(i) == ')') {
                Object pop = stack.pop();
                if ( pop == null || !pop.equals(1)) return false;
            } else if (str.charAt(i) == ']') {
                Object pop = stack.pop();
                if ( pop == null || !pop.equals(2)) return false;
            } else if (str.charAt(i) == '}') {
                Object pop = stack.pop();
                if ( pop == null || !pop.equals(3)) return false;
            }
        }
        return stack.isEmpty();
    }
}
