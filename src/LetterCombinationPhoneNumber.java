import java.util.*;

public class LetterCombinationPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationPhoneNumber obj = new LetterCombinationPhoneNumber();
        System.out.println(obj.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        return letterCombinationsSolve(digits, 0);
    }

    public List<String> letterCombinationsSolve(String digits, int index) {
        if(index == digits.length()) {
            return new ArrayList<>();
        }
        if(index == digits.length() - 1) {
            List<String> output = new ArrayList<>();
            String curr = getNo(digits.charAt(index));
            for(int i = 0;i < curr.length(); i++) {
                char c = curr.charAt(i);
                output.add(c + "");
            }
            return output;
        }
        List<String> smallerOutput = letterCombinationsSolve(digits, index + 1);
        List<String> output = new ArrayList<>();
        String curr = getNo(digits.charAt(index));
        for(int i = 0;i < curr.length(); i++) {
            char c = curr.charAt(i);
            for(String s : smallerOutput) {
                output.add(c + s);
            }
        }
        return output;
    }

    private String getNo(char c) {
        if(c == '2') {
            return "abc";
        } else if(c == '3') {
            return "def";
        } else if(c == '4') {
            return "ghi";
        } else if(c == '5') {
            return "jkl";
        } else if(c == '6') {
            return "mno";
        } else if(c == '7') {
            return "pqrs";
        } else if(c == '8') {
            return "tuv";
        } else {
            return "wxyz";
        }
    }

}
