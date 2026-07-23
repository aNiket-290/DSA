// class Solution {
//     public int maxProfit(int[] prices) {
//         int n=prices.length;
//         int max = 0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if((prices[j]-prices[i])>max) max = prices[j]-prices[i];
//             }
//         }
//         return max;
//     }
// }
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}