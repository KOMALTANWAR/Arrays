public class arraysAssignment{
    //Question -1:Given an integer array nums return true if any element appears at least twice in an array
    //or false if every element is distinct
    public static boolean isrepeated(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    return true;
                }
            }
            
        }
        return false;
    }

    //Question:2 You  are  given  an  array prices where prices[i] is  the  price  of  a  
    // given  stock  on  the ith day.Return the maximum 
    // profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    public static int calculateStockProfit(int prices[]){
        int buyprice=prices[0];
        int sellingPrice;
        int profit=0;
        int max_profit=Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>buyprice){ //Profit day
                sellingPrice=prices[i];
                profit=sellingPrice-buyprice;
                max_profit=Math.max(max_profit,profit);
            }else{
                buyprice=prices[i];
            }
        }
            return max_profit<0? 0: max_profit;
    } 

    // Question 4:Given n non-negative integers representing an elevation map where the width of
    //  each bar is 1, compute how much water it can trap after raining
    public static void main(String args[]){
        int nums[]={1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
      System.out.println(isrepeated(nums));
      int prices[]={7, 6, 4,  3, 1};
      System.out.println(calculateStockProfit(prices));
        
    }
}