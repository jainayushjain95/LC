public class SQRTX {

    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int ans = 0;
        int low = 1, high = x;
        while(low <= high) {
            int mid = low + (high - low)/2;

            if(mid < x/mid) {
                ans = mid;
                low = mid + 1;
            } else if(mid > x/mid) {
                high = mid - 1;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }

    public int mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int ans = 1;
        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((long)(mid * mid) > x) {
                end = mid - 1;
            } else if ((long)(mid * mid) == x) {
                return mid;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] digits = {29};
        System.out.println(new SQRTX().mySqrt(2147395599));
    }
}
