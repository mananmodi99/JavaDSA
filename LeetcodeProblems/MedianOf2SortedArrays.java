package LeetcodeProblems;

public class MedianOf2SortedArrays {
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n = 0,m= 0;
        if(arr1.length<=arr2.length){
            n = arr1.length;
            m = arr2.length;
        }
        else{
            n = arr2.length;
            m = arr1.length;
        }
        int lo = 0, hi = n-1;
        while(lo<=hi){
            int i1 = (lo+hi)/2;
            int i2 = ((n+m+1)/2)-i1;

            int r1 = (i1 >= n)?Integer.MAX_VALUE:arr1[i1];//min1
            int l1 = (i1 <= 0)?Integer.MIN_VALUE:arr1[i1-1];//max1
            int r2 = (i2 >= m)?Integer.MAX_VALUE:arr2[i2];//min2
            int l2 = (i2 <= 0 || i2>=n)?Integer.MIN_VALUE:arr2[i2-1];//max2

            if(l1<=r2 && l2<=r1)
            {
                if((n+m)%2==0)
                    return ((double) Math.max(l1,l2)+Math.min(r1,r2))/(double)2;
                else
                    return (double) Math.max(l1,l2);
            }
            else if(l1>r2)
                hi = i1-1;
            else
                lo = i1+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}
