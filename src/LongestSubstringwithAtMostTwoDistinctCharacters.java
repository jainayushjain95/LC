import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public static void main(String[] args) {
        LongestSubstringwithAtMostTwoDistinctCharacters obj = new LongestSubstringwithAtMostTwoDistinctCharacters();
        System.out.println(obj.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = 0, maxLength = 0, beginIndex = 0, endIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(endIndex < s.length()) {
            char c = s.charAt(endIndex);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                maxLength = Math.max(maxLength, endIndex - beginIndex + 1);
                endIndex++;
            } else if(len < 2) {
                map.put(c, 1);
                maxLength = Math.max(maxLength, endIndex - beginIndex + 1);
                endIndex++;
                len++;
            } else {
                while(len == 2 && beginIndex < endIndex) {
                    char a = s.charAt(beginIndex);
                    int freq = map.get(a);
                    if(freq == 1) {
                        map.remove(a);
                        len--;
                    } else {
                        map.put(a, freq - 1);
                    }
                    beginIndex++;
                }
            }
        }
        return maxLength;
    }

}
