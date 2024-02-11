public class TwoSumLessThanK {

    public static void main(String[] args) {
//        int[] nums = {114,169,633,838,883,265,221,966,389,503,393,260,431,316,261,220,642,664,413,401,150,150,474,558,667,61};
        int[] nums = {642,664,413,401,150,150,474,558,667,61};
        System.out.println(new TwoSumLessThanK().twoSumLessThanK(nums, 100));
    }

    public int twoSumLessThanK(int[] nums, int k) {
        sortArray(nums, 0, nums.length - 1);
        return search(nums, k);
    }

    public int search(int[] nums, int k) {
       int output = -1;
       int beginIndex = 0, endIndex = nums.length - 1;
       while(beginIndex < endIndex) {
           int sum = nums[beginIndex] + nums[endIndex];
           if(sum >= k) {
               endIndex--;
           } else {
               output = Math.max(sum, output);
               beginIndex++;
           }
       }
       return output;
    }

    public void sortArray(int[] nums, int beginIndex, int endIndex) {
        if(beginIndex >= endIndex) {
            return;
        }
        int midIndex = getMidIndex(beginIndex, endIndex);
        sortArray(nums, beginIndex, midIndex);
        sortArray(nums, midIndex + 1, endIndex);

        int[] mergedArray = merge(nums, beginIndex, endIndex, midIndex);
        for(int i = 0; i <= mergedArray.length - 1; i++) {
            nums[i + beginIndex] =  mergedArray[i];
        }
    }

    public int[] merge(int[] nums, int beginIndex, int endIndex, int midIndex) {
        int[] mergedArray = new int[endIndex - beginIndex + 1];
        int index1 = beginIndex;
        int index2 = midIndex + 1;
        int index = 0;

        while(index1 <= midIndex && index2 <= endIndex) {
            if(nums[index1] < nums[index2]) {
                mergedArray[index] = nums[index1];
                index1++;
            } else if(nums[index1] >= nums[index2]) {
                mergedArray[index] = nums[index2];
                index2++;
            }
            index++;
        }

        while(index1 <= midIndex) {
            mergedArray[index] = nums[index1];
            index1++;
            index++;
        }

        while(index2 <= endIndex) {
            mergedArray[index] = nums[index2];
            index2++;
            index++;
        }


        return mergedArray;
    }

    public int getMidIndex(int beginIndex, int endIndex) {
        return (endIndex + beginIndex)/2;
    }

}
