public class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        if(l == 0) return 0;
        
        int minPrice = prices[0], potentialProfit = 0, max = 0;

        /* Runtime is: O(n) greedy appoach */
        for(int price: prices){
           minPrice = Math.min(minPrice, price);
           potentialProfit = price - minPrice;
           max = Math.max(max, potentialProfit);
        }
        
        return max;
        
    }
}