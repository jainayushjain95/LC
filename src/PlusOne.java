public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9, 0};
        System.out.println(new PlusOne().plusOne(digits));
    }

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0) {
            if(digits[index] < 9) {
                digits[index]++;
                return digits;
            }
            digits[index] = 0;
            index--;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
