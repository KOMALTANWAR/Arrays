public class trappingwater{
    public static int trap(int[] height) {
         int n=height.length;
         int bar_water=0;
         int trappedWater=0;
         int left_max[]=new int[n];
         int right_max[]=new int[n];

         //calculating the left max boundary for each element
               left_max[0]=0;
         for(int i=1;i<n;i++){
              if(height[i-1]>left_max[i-1]){
                left_max[i]=height[i-1];
              }else{
                left_max[i]=left_max[i-1];
              }
         }
         printArr(left_max);

         //calculating the right max boundary
         right_max[n-1]=0;
         for(int j=n-2;j>=0;j--){
            if(height[j+1]>right_max[j+1]){
                right_max[j]=height[j+1];
            }else{
                right_max[j]=right_max[j+1];
            }
         }
         printArr(right_max);
         //calcultating water level and max water
        for(int k=0;k<height.length;k++){
            int min_boundary=Math.min(right_max[k], left_max[k]);
           bar_water=(min_boundary-height[k])*1;
            if(bar_water<0){
                trappedWater+=0;
            }else{
                trappedWater+=bar_water;
            }
        }
        return trappedWater;
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
       //Question : Given n non-negative integers representing an elevation
       //  map where the width of each bar is 1, compute how much water it can trap after raining. 

       //Solution
       int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
       System.out.println(trap(height));
       
    }
    }
