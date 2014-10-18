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

}
