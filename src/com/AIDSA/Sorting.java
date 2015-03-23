package com.AIDSA;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MoustaphaSaad on 15/10/2014.
 */
public class Sorting {
    /*
            Initialization:
            loop through array and make a subarray of 0 -> j where in initialize it contains one element so that obviously
            makes it a sorted array.
            Maintenance:
            in each loop we iterate back through the sorted subarray and shift every element to the right into the new space
            that just the j have added and when we find the proper location or we end to the start of the subarray we just
            set the element there.
            Termination:
            the loop ends when the j reachs n so that the subarray will extend to the whole entire array form 0 to n and that
            grantees that it's sorted.

    */
    public static <T extends Comparable<T>> T[] insertionSort(T data[]){
        for(int j = 1;j<data.length;j++){
            //keeping copy of data
            T key = data[j];
            int i = j-1;
            //shifting the elements to the right
            while(i>=0 && data[i].compareTo(key)>0){
                data[i+1] = data[i];
                i = i-1;
            }
            //setting the element in proper location
            data[i+1] = key;
        }
        return data;
    }
    /*

     */
    public static Comparable[] mergeSort(Comparable data[]){
        if (data.length>1){
            int center = data.length /2;
            Comparable[] L = mergeSort(Arrays.copyOfRange(data,0,center));
            Comparable[] R = mergeSort(Arrays.copyOfRange(data,center,data.length));
            data = merge(L,R);

        }
        return data;
    }
    private static Comparable[ ] merge(Comparable d1[],Comparable d2[]){
        Comparable[] arr = new Comparable[d1.length+d2.length];

        int i=0,j=0;
        int curr = 0;

        while(i < d1.length && j < d2.length)
            if(d1[i].compareTo(d2[j])<0)
                arr[curr++] = d1[i++];
            else
                arr[curr++] = d2[j++];

        while(i<d1.length)
            arr[curr++] = d1[i++];

        while(j<d2.length)
            arr[curr++] = d2[j++];

        return arr;
    }

    public static Comparable[] heapSort(Comparable[] arr){
        arr = buildMaxHeap(arr);
        Comparable tmp;
        int n = arr.length;
        for(int i=n-1;i>0;i--){
            tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            maxHeapify(arr,0,i-1);
        }
        return arr;
    }
    private static void maxHeapify(Comparable[] arr, int i, int n){

        //getting the left node of this node
        //while the j is less than the size of the array
        while(i*2+1<n) {
            int j = i*2+1;
            //checking if the right is less than the left node
            //if not then choose the right to be the parent node instead of i
            if(j+1<n && arr[j].compareTo(arr[j+1]) < 0)
                j++;
            //if the i node is greater than the child node then everythng is ok and break
            if(arr[i].compareTo(arr[j]) >=0)
                break;
            else{
                //else then we should swap the i and j node
                //setting the parent node to the biggest child of right and left

                Comparable tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                //setting the j to the left child of children to continue the loop
                i = j;
            }
        }
        //when break then we have reached the place where the i node is and we assign it
        return;
    }
    private static Comparable[] buildMaxHeap(Comparable[] arr){
        int n = arr.length;
        for(int i=n/2;i>=0;i--){
            maxHeapify(arr,i,n);
        }
        return arr;
    }
    private static int partition(Comparable[] arr, int p, int r){
        Comparable x = arr[r];
        int i = p-1;
        for(int j = p;j<r;j++){
            if(arr[j].compareTo(x)<=0){
                i++;
                Comparable tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        Comparable tmp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = tmp;
        return i+1;
    }
    private static Comparable[] quickSortAux(Comparable[] arr, int p, int r){
        if(p<r)
        {
            int q = partition(arr,p,r);
            quickSortAux(arr,p,q-1);
            quickSortAux(arr,q+1,r);
        }
        return arr;
    }
    public static Comparable[] quickSort(Comparable[] arr){

        return quickSortAux(arr,0,arr.length-1);
    }

}
