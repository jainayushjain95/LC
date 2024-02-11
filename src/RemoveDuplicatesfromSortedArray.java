public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new RemoveDuplicatesfromSortedArray().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int index = 0, nextIndex = 0;

        while(nextIndex < nums.length) {
            while(nextIndex < nums.length && nums[index] == nums[nextIndex]) {
                nextIndex++;
            }
            if(nextIndex < nums.length) {
                swap(nums, index + 1, nextIndex);
                index++;
                nextIndex++;
            }
        }

        return index + 1;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
