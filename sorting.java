package Day1;

import java.util.Arrays;
import java.util.Collections;

public class sorting {
    public static void main(String[] args) {
        int arr[]={4,5,1,3,2,9,7,6,8};
        Integer arr1[]={1,4,6,3,2,5};
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
//        Arrays.sort(arr);
//        Arrays.sort(arr,0,3);
//        Arrays.sort(arr1, Collections.reverseOrder());
//        Arrays.sort(arr1,3,5,Collections.reverseOrder());
        int nums[]={0,1,3,2,2,1,1,3,0,0,3,1};
//        CountingSort(nums);
        printArr(nums);
    }
    //bubble sort
    public static void bubbleSort(int arr[]){
        int swaps=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swaps++;
                }
            }
            if(swaps==0){
                return;
            }
        }
    }
    //selection sort
    public static void selectionSort(int arr[]){
        int min;
        for(int i=0;i<arr.length-1;i++){
            min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }
    //insertion sort
    public static void insertionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }

        }

    }
    //Counting sort( array with low range and positive numbers)
    public static void CountingSort(int nums[]){
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int temp[]=new int[max+1];
        for(int i=0;i<nums.length;i++){
            temp[nums[i]]+=1;
        }
        int idx=0;
        for(int i=0;i<temp.length;i++){
            int curr=temp[i];
            while(curr!=0){
                nums[idx++]=i;
                curr--;
            }
        }
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }

}
