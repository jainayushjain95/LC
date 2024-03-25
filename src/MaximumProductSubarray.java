public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray obj = new MaximumProductSubarray();
        int[] nums = {-2};
        System.out.println(obj.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int result = nums[0], maxSoFar = nums[0], minSoFar = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int a = n * minSoFar;
            int b = n * maxSoFar;
            int tempMinSoFar = Math.min(n, Math.min(a, b));
            maxSoFar = Math.max(n, Math.max(a, b));
            minSoFar = tempMinSoFar;
            result = Math.max(maxSoFar, result);
        }
        return result;
    }

}
