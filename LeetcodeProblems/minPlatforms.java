package LeetcodeProblems;
import java.util.*;
public class minPlatforms {
    public static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);Arrays.sort(dep);
        int max = 0, pf = 0, lo = 0, hi = 0;
        while(lo<n && hi<n){
            if(arr[lo]<=dep[hi])
            {
                pf++; lo++;
            }
            else if(arr[lo]>dep[hi]){
                pf--;
                hi++;
            }
            max = Math.max(pf, max);
        }
        return max;
    }
}
