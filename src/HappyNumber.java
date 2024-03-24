import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(1));
    }

    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        boolean isHappy = false;
        set.add(n);
        while(!isHappy) {
            int sum = getSquaredSumOfDigits(n);
            if(set.contains(sum)) {
                break;
            }
            set.add(sum);
            isHappy = sum == 1;
            n = sum;
        }
        return isHappy;
    }

    public boolean isHappy2(int n) {
        if(n == 1) {
            return true;
        }

        int hare = getSquaredSumOfDigits(n), tortoise = n;

        while(hare != tortoise && hare != 1) {
            tortoise = getSquaredSumOfDigits(tortoise);
            hare = getSquaredSumOfDigits(getSquaredSumOfDigits(hare));
        }

        return hare == 1;
    }

    public int getSquaredSumOfDigits(int n) {
        int sum = 0;
        while(n != 0) {
            int k = n % 10;
            sum += k * k;
            n = n / 10;
        }
        return sum;
    }
}
