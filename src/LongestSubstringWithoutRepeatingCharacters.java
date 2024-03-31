import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("aaaaa"));
    }


    public int lengthOfLongestSubstring(String s) {
        int lengthOfLongestSubstring = 0;
        int beginIndex = 0, endIndex = 0;
        Set<Character> set = new HashSet<>();

        while(endIndex < s.length()) {
            char c = s.charAt(endIndex);
            if(!set.contains(c)) {
                set.add(c);
                lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, endIndex - beginIndex + 1);
                endIndex++;
            } else {
                while (beginIndex < endIndex && set.contains(c)) {
                    set.remove(s.charAt(beginIndex++));
                }
            }
        }
        return lengthOfLongestSubstring;
    }

}
