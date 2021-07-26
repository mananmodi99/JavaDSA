package LeetcodeProblems;

public class KthElemof2SortedArray {
    public long kthElement(int arr1[], int[] arr2, int n, int m, int k) {
        if(arr1.length<=arr2.length)
            return kthElem(arr1, arr2, k);
        return kthElem(arr2, arr1, k);
    }
    public long kthElem(int[] arr1, int[] arr2, int k){
        int n = arr1.length, m = arr2.length;
        int lo = Math.max(0, k-m);
        int hi = Math.min(k, n);
        while(lo<=hi){
            int i1 = (lo+hi)/2;
            int i2 = k-i1;
            int l1 = (i1 == 0)?Integer.MIN_VALUE:arr1[i1-1];
            int l2 = (i2 == 0)?Integer.MIN_VALUE:arr2[i2-1];
            int r1 = (i1 == n)?Integer.MAX_VALUE:arr1[i1];
            int r2 = (i2 == m)?Integer.MAX_VALUE:arr2[i2];
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2)
                hi = i1-1;
            else
                lo = i1+1;
        }
        return -1;
    }
}
