import java.util.Arrays;
public class arrSorting{


   //bubble Sort 
    public static void bubbleSort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
               if(arr[j]>arr[j+1]){
              //  swap
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
               }
               printArr(arr);
            }
            System.out.println("this is round "+ i);
             printArr(arr);
          
        }
    }



    //Selection Sort 
public static void selectionSort(int arr[]){
    for(int i=0;i<arr.length;i++){
        int minPos=i;
        for(int j=i;j<arr.length;j++){
            if(arr[j]<arr[minPos]){
                //swap
                int temp=arr[minPos];
                arr[minPos]=arr[j];
                arr[j]=temp;
            }
        }
    }
    printArr(arr);
}

   //Insertion Sort
public static void insertionSort(int arr[]){
  for(int i=1;i<arr.length;i++){
    int curr=arr[i];
    int prev=i-1;
    while(prev>=0 && arr[prev]>curr){
        //Shift
        arr[prev+1]=arr[prev];
        prev--;
    }
      arr[prev+1]=curr;
  }
    printArr(arr);
}

  //Counting Sort
public static void CountingSort(int arr[]){
    int CountArr[]=new int[3];
    for(int i=0;i<arr.length;i++){
      CountArr[arr[i]]++;
    }
    printArr(CountArr);
    int index=0;
    for(int j=0;j<CountArr.length;j++){
        int count=CountArr[j];
        while(count>0 && index<arr.length){
            arr[index]=j;
            count--;
            index++;
        }
    }
    printArr(arr);
}
    //print an array
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String args[]){
        int arr[]={5,6,3,1,2,4,5,6};
        // bubbleSort(arr);
       // selectionSort(arr);
       // insertionSort(arr);
      // CountingSort(arr);
      Arrays.sort(arr); //inbuilt -Sort
      printArr(arr);
    }
}