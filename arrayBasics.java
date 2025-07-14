public class arrayBasics{
    //brute force to find largest in an array
    public static int findLargest(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        return largest;
    }
    //Linear Search 
    public static int linearSearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }

    //Binary search to find an element in an array
    public static int binarySearch(int arr[],int key){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]>key){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    //reverse of an array
    public static void reverseArr(int arr[]){
        int n=arr.length;
        for(int i=0;i<n/2;i++){
            //swap the starting element with the corresponding last element
            int temp=arr[i];
            arr[i]=arr[n-1-i];
            arr[n-1-i]=temp;
        }
        printArr(arr);
    }
    //to print an array
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    //to print unique pairs of array elements
    public static void printPairs(int arr[]){
    for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
            System.out.println("("+arr[i]+","+arr[j]+")");
        }
    }
    }
    //to print subarrays of the array 
    public static void printSubarrays(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
       int arr[]={1,2,3,4,5};
       findLargest(arr);
      binarySearch(arr,1220);
      linearSearch(arr,122);
      //reverseArr(arr);
      printPairs(arr);
      printSubarrays(arr);

    }
}