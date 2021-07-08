package TimeandSpaceComplexity;

public class MergeSort {
    public static void main(String[] args) {
       int[] arr = {2,4,1,3,5};
       int lo = 0, hi = arr.length-1;
       SortFunc(arr, lo, hi);
        for (int i: arr) {
            System.out.println(i);
        }
    }

    private static void SortFunc(int[] arr, int lo, int hi) {
        if(lo<hi){
            int mid = lo+(hi-lo)/2 ;//to avoid overflow
            SortFunc(arr, lo, mid); //left
            SortFunc(arr, mid+1, hi); //right
            MergeTwoSortedArr(arr, lo, hi, mid);
        }
    }

    public static void MergeTwoSortedArr(int[] arr, int lo, int hi, int mid){
        int arr1[] = new int[mid-lo+1];
        int arr2[] = new int[hi - mid];
        for(int i = 0; i<arr1.length; i++){
            arr1[i] = arr[i+lo];
        }
        for(int i = 0 ; i<arr2.length ; i++){
            arr2[i] = arr[mid+1+i];
        }
        int i=0,j=0,k=lo;
        while(i<arr1.length && j<arr2.length){
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
                k++;
            }
            else{
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }
        if(i== arr1.length){
            while(j<arr2.length){
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }
        else{
            while(i<arr1.length){
                arr[k] = arr1[i];
                i++;
                k++;
            }
        }
    }
}
