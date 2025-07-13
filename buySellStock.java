public class buySellStock{
//     Question:You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

//Solution function:
    public static int maxProfit(int[] prices) {
        int buy_price=prices[0];
        int selling_price;
        int profit;
        int max_profit=Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
          selling_price=prices[i];
          if(selling_price>buy_price){ //profit day
               profit=selling_price-buy_price;
               max_profit=Math.max(max_profit, profit);
               profit=0;
          }else{
            buy_price=selling_price;
          }
        }
        return max_profit<0?0:max_profit;
    }

    public static void main(String args[]){
        int prices[]={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }
}