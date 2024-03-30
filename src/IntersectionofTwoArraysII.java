import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII {

    public static void main(String[] args) {
        System.out.println('c' - 'a');
        IntersectionofTwoArraysII obj = new IntersectionofTwoArraysII();
        int[] nums1 = {0};
        int[] nums2 = {0};
        int[] intersect = obj.intersect(nums1, nums2);
        for(int x : intersect) {
            System.out.println(x);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        for(int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(int x : nums2) {
            int val = map.getOrDefault(x, 0);
            if(val > 0) {
                output.add(x);
                map.put(x, val - 1);
            }
        }

        int[] result = new int[output.size()];
        int index = 0;
        for(int x : output) {
            result[index++] = x;
        }
        return result;
    }



}
