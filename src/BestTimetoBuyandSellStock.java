public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new BestTimetoBuyandSellStock().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int maxProfit = 0, base = prices[0];

        for(int i = 1;i < prices.length; i++) {
            if(prices[i] >= base) {
                maxProfit = Math.max(maxProfit, prices[i] - base);
            } else {
                base = prices[i];
            }
        }

        return maxProfit;
    }

}
