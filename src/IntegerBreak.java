public class IntegerBreak {

    int[] dp;

    public static void main(String[] args) {
        IntegerBreak obj = new IntegerBreak();

        System.out.println(obj.integerBreak(100));
    }
    public int integerBreak(int n) {
        if(n <= 3) {
            return n - 1;
        }
        dp = new int[n + 1];
        dp[2] = 1;
        dp[3] = 2;
        return integerBreakSolveDP(n);
    }

    public int integerBreakSolve(int n) {
        if(n <= 3) {
            return n;
        }
        int output = 1;
        for(int i = 2; i <= n - 2; i++) {
            output = Math.max(output, i * integerBreakSolve(n - i));
        }
        return output;
    }

    public int integerBreakSolveDP(int n) {
        if(n <= 3) {
            return n;
        }

        if(dp[n] != 0) {
            System.out.println("Picked from DP: " + n);
            return dp[n];
        }
        int output = 1;
        for(int i = 2; i <= n - 2; i++) {
            output = Math.max(output, i * integerBreakSolveDP(n - i));
        }
        dp[n] = output;
        return output;
    }

}
