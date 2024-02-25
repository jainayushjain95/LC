import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequence {

    public static void main(String[] args) {
        String[] words = {"e", "a", "b"};
        int[] groups = {0, 0, 1};
        System.out.println(new LongestUnequalAdjacentGroupsSubsequence().getLongestSubsequence(words, groups));
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int prev = groups[0];
        ans.add(words[0]);

        for(int i = 1;i < words.length; i++) {
            if(groups[i] != prev) {
                ans.add(words[i]);
                prev = groups[i];
            }
        }

        return ans;
    }

}
