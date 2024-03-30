public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes obj = new MoveZeroes();
        int[] nums = {0};
        obj.moveZeroes(nums);
        for(int x : nums) {
            System.out.println(x);
        }
    }

    public void moveZeroes(int[] nums) {
        int beginIndex, zeroIndex = -1;
        for (beginIndex = 0; beginIndex < nums.length; beginIndex++) {
            if(nums[beginIndex] == 0) {
                if(zeroIndex == -1) {
                    zeroIndex = beginIndex;
                }
            } else if(zeroIndex != -1) {
                swap(nums, zeroIndex, beginIndex);
                zeroIndex++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
