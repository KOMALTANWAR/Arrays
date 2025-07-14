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

    // Question 3:Given n non-negative integers representing an elevation map where the width of
    //  each bar is 1, compute how much water it can trap after raining
       public static int trappedWater(int height[]){
          int n=height.length;
          int left_max[]=new int[n];
          int right_max[]=new int[n];
          int trappedWater=0;

          //calculate left max boundary
          left_max[0]=0;
          for(int i=1;i<n;i++){
            if(height[i-1]>left_max[i-1]){
                left_max[i]=height[i-1];
            }else{
                left_max[i]=left_max[i-1];
            }
          }
          //calculating the right max boundary
          right_max[n-1]=0;
          for(int j=n-2;j>=0;j--){
               if(right_max[j+1]>height[j+1]){
                   right_max[j]=right_max[j+1];
               }else{
                   right_max[j]=height[j+1];
               }
          }
          for(int k=0;k<height.length;k++){
            int min_boundary=Math.min(right_max[k],left_max[k]);
           int water=(min_boundary-height[k])*1;
           water=water<0?0:water;
           trappedWater+=water;
          }
          return trappedWater;
       }
       public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
        }
       }
       //optimised trapped rainwater
       public static int trappedWaterOptimised(int arr[]){
        int left=0;
        int right=0;
        int end=arr.length;
        int water=0;
        int trappedWater=0;
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            //calculating water for each bar
            int boundary=Math.min(left,right);
            water=(boundary-arr[i])*1;
            water=water<0?0:water;
            trappedWater+=water;
            if(arr[i]>left){
                left=arr[i];
            }
            if(arr[end-1-i]>right){
                right=arr[end-1-i];
            }
        } 
        return trappedWater;

       }

    //    Question 4:There is an integer array nums sorted in ascending order (with distinct values).Prior 
    //    to being passed to your function, nums is possibly rotated at an unknown pivot  index k (1  <=  k  <  nums.length)  such  that  the  resulting  array  is [nums[k], nums[k+1],   ...,   nums[n-1], nums[0],   nums[1],   ...,   nums[k-1]] (0-indexed).   For   example, [0,1,2,4,5,6,7] might        be        rotated        at        pivot        index 3   and become [4,5,6,7,0,1,2].Given the array nums after the possible rotation and 
    //    an integer target, returnthe index oftarget if it is in nums, or -1   if it is not in nums.
    public static int pivotSearch(int arr[],int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[start]<=arr[mid]){//check is left half is sorted
                  if(arr[start]<=target && target<=arr[mid]){//check is key lies within the left sorted part
                      //if key lies in it then discard the right part
                      end=mid-1;
                  }else{
                    //if it is sorted but key doesn't lies within it
                    //discard the left part
                    start=mid+1;
                  }
            }
            else{//right half is sorted
             //check is key lies within it
             if(arr[mid]<=target && target<=arr[end]){
                //if it lies then discard the left part
                start=mid+1;
             }else{
                //if not lies
                end=mid-1;
             }

            }
        }
        return -1;
        }
     


    
       
    public static void main(String args[]){
    //     int nums[]={1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
    //   System.out.println(isrepeated(nums));
    //   int prices[]={7, 6, 4,  3, 1};
    //   System.out.println(calculateStockProfit(prices));
      int arr[]={4, 2, 0, 3, 2, 5};
     System.out.println(trappedWaterOptimised(arr));
     System.out.println(trappedWater(arr));
    //  int rotatedSortedArr[]={4,5,6,7,8,0,1,2,3};
    //  System.out.println(pivotSearch(rotatedSortedArr,90));
     
        
    }
}