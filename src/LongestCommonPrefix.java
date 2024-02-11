public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefixBruteForce(strs);
    }

    public String longestCommonPrefixBruteForce(String[] strs) {
        String lcp = "";
        boolean allIsWell = true;
        int length = 0;
        while(allIsWell) {
            if(strs[0].length() <= length) {
                allIsWell = false;
                break;
            }
            char c = strs[0].charAt(length);
            for(int i = 1;i < strs.length; i++) {
                if(strs[i].length() <= length || strs[i].charAt(length) != c) {
                    allIsWell = false;
                    break;
                }
            }
            if(allIsWell) {
                lcp += c;
                length++;
            }
        }
        return lcp;
    }


}
