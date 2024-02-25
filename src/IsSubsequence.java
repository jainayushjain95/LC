public class IsSubsequence {

    public static void main(String[] args) {
        String s = "abdc", t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));
    }
    public boolean isSubsequence(String s, String t) {
        return isSubsequenceSolve1(s, t, 0, 0);
    }

    public boolean isSubsequenceSolve1(String s, String t, int i1, int i2) {
        if(i1 >= s.length()) {
            return true;
        }
        if(i2 >= t.length()) {
            return false;
        }
        if(s.charAt(i1) == t.charAt(i2)) {
            return isSubsequenceSolve1(s, t, i1 + 1, i2 + 1);
        }
        return isSubsequenceSolve1(s, t, i1, i2 + 1);
    }

}
