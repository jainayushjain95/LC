public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                i--;
                index--;
            } else if(nums1[i] < nums2[j]) {
                nums1[index] = nums2[j];
                j--;
                index--;
            } else {
                nums1[index] = nums1[i];
                nums1[index - 1] = nums2[j];
                i--;
                j--;
                index -= 2;
            }
        }

        while(j >= 0) {
            nums1[index] = nums2[j];
            j--;
            index--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 7, 7, 8, 10, 0, 0, 0, 0};
        int m = 6, n = 4;
        int[] nums2 = {1, 7, 8, 14};
        new MergeSortedArray().merge(nums1, m, nums2, n);
        for(int x : nums1) {
            System.out.println(x);
        }
    }

}
