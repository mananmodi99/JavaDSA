package LeetcodeProblems;

public class MaximumNumberOf1s {
    public int findMaxConsecutiveOnes(int[] arr) {
        if(arr.length == 0) return 0;
        int max = 0, cnt = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 1) cnt++;
            else{
                max = Math.max(cnt, max);
                cnt = 0;
            }
        }
        return Math.max(cnt,max);
    }
}
