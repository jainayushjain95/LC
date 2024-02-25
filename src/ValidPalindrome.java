public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        boolean isPalindrome = true;
        int beginIndex = 0, endIndex = s.length() - 1;
        while(beginIndex < endIndex && isPalindrome) {
            char bi = s.charAt(beginIndex);
            char ei = s.charAt(endIndex);
            if(!CommonUtils.isAlphaNumeric(bi)) {
                 beginIndex++;
            } else if(!CommonUtils.isAlphaNumeric(ei)) {
                endIndex--;
            } else {
                isPalindrome = CommonUtils.toLowerCase(bi) == CommonUtils.toLowerCase(ei);
                beginIndex++;
                endIndex--;
            }
        }
        return isPalindrome;
    }

}
