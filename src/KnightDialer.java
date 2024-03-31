import java.util.ArrayList;
import java.util.List;

public class KnightDialer {

    private int[][] movementsMap;
    private int[][] dp;
    private static int modulo = 1000000007;

    public static void main(String[] args) {
        KnightDialer obj = new KnightDialer();
        System.out.println(obj.knightDialer(3131));
    }

    private void initialize(int n) {
        this.movementsMap = new int[][] {
                {4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}
        };

        this.dp = new int[n + 1][11];
        for(int i = 0;i <= 10; i++) {
            dp[1][i] = 1;
        }
    }

    public int knightDialer(int n) {
        if(n == 1) {
            return 10;
        }
        initialize(n);
        int solution = 0;
        for(int position = 0; position <= 9; position++) {
            int[] movements = this.movementsMap[position];
            for(int index = 0; index < movements.length; index++) {
                if(n > 1) {
                    solution += knightDialerSolve1(n - 1, movements[index]);
                    if(solution >= modulo) {
                        solution = solution % modulo;
                    }
                }
            }
        }
        return solution;
    }

    public int knightDialerSolve1(int n, int position) {
//        System.out.println(n + " --> " + position);
        if(n == 1) {
            return 1;
        }

        if(n <= 0) {
            return 0;
        }

        if(dp[n][position] != 0) {
            return dp[n][position];
        }

        int solution = 0;
        int[] movements = this.movementsMap[position];
        for(int index = 0; index < movements.length; index++) {
            solution += knightDialerSolve1(n - 1, movements[index]);
            if(solution >= modulo) {
                solution = solution % modulo;
            }
        }
        dp[n][position] = solution;
        return solution;
    }

}
