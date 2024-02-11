public class RemoveDuplicatesfromSortedArray2 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(new RemoveDuplicatesfromSortedArray2().removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        int index = 0, nextIndex = 0;
        while(nextIndex < nums.length) {

            while(nextIndex < nums.length && nums[index] == nums[nextIndex]) {
                nextIndex++;
            }

            int placeHolder = nextIndex;

            if(nextIndex < nums.length) {
                int temp = nums[nextIndex];

                while(nextIndex < nums.length && temp == nums[nextIndex]) {
                    nextIndex++;
                }

                int times = Math.min(2, nextIndex - placeHolder);

                while(placeHolder < nums.length && times != 0) {
                    swap(nums, index + 1, placeHolder);
                    placeHolder++;
                    index++;
                    times--;
                }
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
