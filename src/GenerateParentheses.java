import java.util.*;

public class GenerateParentheses {

    List<String> output;

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        System.out.println(obj.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        output = new ArrayList<>();
        generateParenthesisSolve(n, n, "");
        return output;
    }

    public void generateParenthesisSolve(int lefts, int rights, String curr) {
        if(lefts == 0 && rights == 0) {
            output.add(curr);
        }
        if(lefts > 0) {
            generateParenthesisSolve(lefts - 1, rights, curr + "(");
        }

        if(rights - lefts > 0) {
            generateParenthesisSolve(lefts, rights - 1, curr + ")");
        }
    }

}
