public class FindtheIndexoftheFirstOccurrenceinString {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(new FindtheIndexoftheFirstOccurrenceinString().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int hayStackIndex = 0;
        boolean found = false;
        while(!found && hayStackIndex <= haystack.length() - needle.length()) {
            int needleIndex = 0, index = hayStackIndex;
            while(needleIndex < needle.length() && needle.charAt(needleIndex) == haystack.charAt(index)) {
                needleIndex++;
                index++;
            }
            found = needleIndex == needle.length();
            hayStackIndex++;
        }
        return found ? hayStackIndex - 1 : -1;
    }

}
