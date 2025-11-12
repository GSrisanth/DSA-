// Selection sort

import java.util.Arrays;

class Selection{
    static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i =0; i<n-1;i++){
            //assume the current position the minimum element

            int min_idx = i;
            //now iterate through the unsorted array to find the smallest/largest element
            
            for(int j = i+1; j<n; j++){
                if(arr[j]<arr[min_idx]){
                    min_idx = j;
                }
            }
            // now we have to move the minimum element to its correct position

            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }
    static void printArray(int [] arr ){
        for (int val : arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public static void main(String [] args){
        int [] arr = {64,25,12,22,11};

        System.out.println("Original Array : ");
        printArray(arr);

        selectionSort(arr);

        System.out.print("Sorted array :");
        printArray(arr);
    }
}




