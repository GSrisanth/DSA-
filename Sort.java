// Selection sort

// import java.util.Arrays;

// class Sort{
//     static void selectionSort(int[] arr){
//         int n = arr.length;
//         for(int i =0; i<n-1;i++){
//             //assume the current position the minimum element

//             int min_idx = i;
//             //now iterate through the unsorted array to find the smallest/largest element
            
//             for(int j = i+1; j<n; j++){
//                 if(arr[j]<arr[min_idx]){
//                     min_idx = j;
//                 }
//             }
//             // now we have tro move the minimum element to its correct position

//             int temp = arr[i];
//             arr[i] = arr[min_idx];
//             arr[min_idx] = temp;
//         }
//     }
//     static void printArray(int [] arr ){
//         for (int val : arr){
//             System.out.print(val + " ");
//         }
//         System.out.println();
//     }
//     public static void main(String [] args){
//         int [] arr = {64,25,12,22,11};

//         System.out.println("Original Array : ");
//         printArray(arr);

//         selectionSort(arr);

//         System.out.print("Sorted array :");
//         printArray(arr);
//     }
// }


// Merge Sort

import java.util.*;

public class Sort{
    public static void conquer(int arr[], int si, int mid, int ei){
        int merged[] = new int[ei - si +1];

        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        while(idx1 <= mid && idx2 <= ei){
            if(arr[idx1] <= arr[idx2]){
                merged[x] = arr[idx1];
                x++;idx1++;
            }else {
                merged[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid){
            merged[x++] = arr[idx1++];
        }

        while (idx2 <= ei){
            merged[x++] = arr[idx2++];
        }

        for(int i =0,j = si ; i<merged.length; i++,j++){
            arr[j] = merged[i];
        }

    }

    public static void divide(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }

        int mid = si + (ei - si)/2;
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);

    }




    public static void main(String[] args){
        int arr[] = {6,3,9,5,2,8};
        int n = arr.length;

        divide(arr, 0 ,n-1);
        //print
        for(int i =0; i<n; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
 