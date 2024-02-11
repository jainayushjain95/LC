import java.util.Map;

public class DP {

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(new DP().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairsRecBottomUpDP(cost);
    }

    public int minCostClimbingStairsRec(int[] cost, int start) {
        if(start >= cost.length) {
            return 0;
        }

        if(start == cost.length - 1) {
            return cost[start];
        }

        int base = (start == -1) ? 0 : cost[start];

        return base + Math.min(minCostClimbingStairsRec(cost, start + 1), minCostClimbingStairsRec(cost, start + 2));
    }

    public int minCostClimbingStairsRecBottomUpDP(int[] cost) {
        if(cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dpArray = new int[cost.length + 1];
        dpArray[dpArray.length - 1] = cost[cost.length - 1];
        dpArray[dpArray.length - 2] = cost[cost.length - 2];

        for(int i = cost.length - 2; i >= 0; i--) {
            int base = i >= 1 ? cost[i - 1] : 0;
            dpArray[i] = base + Math.min(dpArray[i + 1], dpArray[i + 2]);
        }
        return dpArray[0];
    }
    public int minCostClimbingStairsRecTopDownDP(int[] cost, int start, int[] dpArray) {
        if(start >= cost.length) {
            return 0;
        }

        if(start == cost.length - 1) {
            dpArray[start] = cost[start];
            return cost[start];
        }

        if(start != -1 && dpArray[start] != -1) {
            return dpArray[start];
        }

        int base = (start == -1) ? 0 : cost[start];

        int solution = base + Math.min(minCostClimbingStairsRecTopDownDP(cost, start + 1, dpArray), minCostClimbingStairsRecTopDownDP(cost, start + 2, dpArray));
        if(start != -1) {
            dpArray[start] = solution;
        }
        return solution;
    }

    public int fib(int n) {
        if(n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fibDP(int n) {
        if(n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairs(int n) {
        return climbStairsDP(n);
    }

    public int climbStairsDP(int n) {
        if(n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }

    public int climbStairsBF(int n, int start) {
        if(start > n) {
            return 0;
        }
        if(start == n) {
            return 1;
        }
        return climbStairsBF(n, start + 1) + climbStairsBF(n, start + 2);
    }

}
