public class ValidAnagram {

    public static void main(String[] args) {
        char a = 'z';
        System.out.println((int)(a - 'a'));
//        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        boolean validAnagrams = true;
        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for(int i = 0;i < s.length(); i++) {
            a1[s.charAt(i) - 'a']++;
            a2[t.charAt(i) - 'a']++;
        }

        for(int i = 0;validAnagrams && i < 26; i++) {
            validAnagrams = a1[i] == a2[i];
        }

        return validAnagrams;
    }

}
