package TimeandSpaceComplexity;

public class MergeSort {
    public static void main(String[] args) {
       int[] arr = {20,10,30,50,60,5,80,25};
       int lo = 0, hi = arr.length-1;
       int[] sorted = SortFunc(arr, lo, hi);
        for (int i: sorted) {
            System.out.println(i);
        }
    }

    private static int[] SortFunc(int[] arr, int lo, int hi) {
        if(lo == hi){
            int[] base = new int[1];
            base[0] = arr[lo];
            return base;
        }
        int mid = (lo+hi)/2;
        int[] arr1 = SortFunc(arr, lo, mid);
        int[] arr2 = SortFunc(arr, mid+1, hi);
        return MergeTwoSortedArr(arr1, arr2);
    }

    public static int[] MergeTwoSortedArr(int[] arr1, int[] arr2){
        int[] merged = new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length && j<arr2.length){
            if (arr1[i] <= arr2[j]) {
                merged[k] = arr1[i];
                i++;
                k++;
            }
            else{
                merged[k] = arr2[j];
                j++;
                k++;
            }
        }
        if(i== arr1.length){
            while(j<arr2.length){
                merged[k] = arr2[j];
                j++;
                k++;
            }
        }
        else{
            while(i<arr1.length){
                merged[k] = arr1[i];
                i++;
                k++;
            }
        }
        return merged;
    }
}
