import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DP {

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
//        System.out.println(new DP().divisorGame(4));
    }


    //Pascal 1
    //https://leetcode.com/problems/pascals-triangle/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();

        List<Integer> rowOne = new ArrayList<>();
        rowOne.add(1);
        output.add(rowOne);

        if(numRows > 1) {
            int row = 2;
            while(row <= numRows) {
                List<Integer> newRow = new ArrayList<>();
                newRow.add(1);
                int col = 0;
                List<Integer> oldRow = output.get(row - 2);
                while(col < row - 2) {
                    newRow.add(oldRow.get(col) + oldRow.get(col + 1));
                    col++;
                }
                newRow.add(1);
                output.add(newRow);
                row++;
            }
        }

        return output;
    }

    public int[] countBits(int n) {
        return countBitsDP(n);
    }

    public int[] countBitsDP(int n) {
        int[] bitsCount = new int[n + 1];
        if(n == 0) {
            return bitsCount;
        }

        if(n == 1) {
            bitsCount[1] = 1;
            return bitsCount;
        }

        bitsCount[1] = 1;
        int size = 2, index = 2;
        while(index <= n) {
            int k = size/2;
            while(index <= n && k < size) {
                bitsCount[index++] = bitsCount[k++];
            }
            k = size/2;
            while(index <= n && k < size) {
                bitsCount[index++] = 1 + bitsCount[k++];
            }
            size *= 2;
        }

        return bitsCount;
    }



    public int[] countBitsBF(int n) {
        int[] bitsCount = new int[n + 1];
        for(int i = 0;i <= n; i++) {
            bitsCount[i] = CommonUtils.getNoOfSetBits(i);
        }
        return bitsCount;
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
