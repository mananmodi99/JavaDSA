package LeetcodeProblems;

public class Merge2SortedArray {
    public void mergeInsertionSort(int[] arr1, int m, int[] arr2, int n) {
        if(arr2.length!=0){
            for(int i = 0; i<m; i++){
                if(arr1[i]>arr2[0]){
                    int temp = arr1[i];
                    arr1[i] = arr2[0];
                    arr2[0] = temp;
                    int j;
                    for(j = 1; j<n && arr2[j]<arr2[0]; j++){
                        arr2[j-1] = arr2[j];
                    }
                    arr2[j-1] = temp;
                }
            }
            int j = 0;
            for(int i = m; i<arr1.length; i++){
                arr1[i] = arr2[j];
                j++;
            }
        }
        if(m==0){
            int j = 0;
            for(int i = m; i<arr1.length; i++){
                arr1[i] = arr2[j];
                j++;
            }
        }
    }



    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int j = 0;
        for(int i = m; i<arr1.length; i++){
            arr1[i] = arr2[j];
            j++;
        }
        int gap = (m+n)/2;
        while(gap>=1){
            int lo = 0, hi = gap;
            while(hi<arr1.length){
                if(arr1[lo]<arr1[hi]){
                    lo++;hi++;
                }
                else{
                    int temp = arr1[lo];
                    arr1[lo] = arr1[hi];
                    arr1[hi] = temp;
                    lo++;
                    hi++;
                }
            }
            gap = gap/2 + gap%2;
        }
    }


}
