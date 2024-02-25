public class CommonUtils {
    public static void printArray(int[] data) {
        for(int x : data) {
            System.out.println(x);
        }
    }

    public static int getNoOfSetBits(int n) {
        int setBitsCount = 0;
        while(n > 0) {
            setBitsCount += n & 1;
            n = n >> 1;
        }
        return setBitsCount;
    }

    public static boolean isAlphaNumeric(char c) {
        int val = c - 0;
        return val >= 65 && val <= 90 || val >= 97 && val <= 122 || val >= 48 && val <= 57;
    }

    public static char toLowerCase(char c) {
        if(c >= 'A' && c <= 'Z') {
            c = (char) (c + 'a' - 'A');
        }
        return c;
    }

    public static int getLengthOfLL(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
