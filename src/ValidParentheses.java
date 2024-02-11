import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "({{{{}}}})[(){]";
        System.out.println(new ValidParentheses().isValid(s));
    }

    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        boolean isValid = true;

        for(int i = 0;i < s.length(); i++) {
            char c = s.charAt(i);
            if(isOpeningBracket(c)) {
                stack.push(c);
            } else if(stack.isEmpty() || stack.peek() != getBracketOpeningPair(c)) {
                isValid = false;
                break;
            } else {
                stack.pop();
            }
        }

        return isValid && stack.isEmpty();
    }

    private boolean isOpeningBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private char getBracketOpeningPair(char c) {
        if(c == ')') {
            return '(';
        } else if(c == '}') {
            return '{';
        }
        return '[';
    }
}
