public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(obj.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int output = (nums.length * (nums.length + 1))/2;
        for(int x : nums) {
            output -= x;
        }
        return output;
    }

}
