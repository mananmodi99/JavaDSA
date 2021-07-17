package LeetcodeProblems;

public class RemoveDuplicatesFromSortedarr {
    public int removeDuplicates(int[] arr) {
        if(arr.length < 1) return 0;
        int lo = 0, hi = 1;
        while(hi<arr.length){
            if(arr[lo] == arr[hi]){
                hi++;
            }
            else{
                arr[lo+1] = arr[hi];
                lo++;
                hi++;
            }
        }
        return lo+1;
    }
}
