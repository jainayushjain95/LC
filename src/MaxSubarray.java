public class MaxSubarray {

    public static void main(String[] args) {
        MaxSubarray obj = new MaxSubarray();
        int[] nums = {5,4,-1,7,8};
        System.out.println(obj.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int maxAbsoluteSum = nums[0], sumSoFar = nums[0];
        for(int i = 1;i < nums.length; i++) {
            int x = nums[i];
            if(x > sumSoFar + x) {
                sumSoFar = x;
            } else {
                sumSoFar += x;
            }
            maxAbsoluteSum = Math.max(sumSoFar, maxAbsoluteSum);
        }
        return maxAbsoluteSum;
    }

}
