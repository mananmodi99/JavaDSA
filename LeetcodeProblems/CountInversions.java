package LeetcodeProblems;
import java.util.*;
import java.io.*;
import java.lang.*;
//Problem Link: https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

class CountInversions
{
    static long Naive(long arr[], long N)
    {
        long count = 0;
        for(int i = 0; i<N; i++){
            for(int j = i+1; j<N; j++){
                if(arr[i]>arr[j])
                    count++;
            }
        }
        return count;
    }
    static long inversionCount(long arr[], long N)
    {
        long count = 0;

        count += SortFunc(arr, 0, arr.length-1);


        return count;
    }
    static long SortFunc(long[] arr, int lo, int hi){
        long count = 0;
        if(lo<hi){
            int mid = lo+(hi-lo)/2;
            count += SortFunc(arr, lo, mid);
            count += SortFunc(arr, mid+1, hi);
            count += merge2sortedArr(arr, lo, mid, hi);
        }
        return count;
    }
    static long merge2sortedArr(long[] arr, int l,int m, int r)
    {

        // Left subarray
        long[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        long[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        long swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }
}