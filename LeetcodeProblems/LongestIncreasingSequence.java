package LeetcodeProblems;
import java.util.*;
public class LongestIncreasingSequence {
    public static void main(String[] args) {
        System.out.println(Best(new int[]{0,1,1,2}));
    }
    public static int Best(int[] arr){
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<arr.length; i++)
            set.add(arr[i]);

        for(int i = 0; i<arr.length; i++){
            if(!set.contains(arr[i]-1)){
                int curr = 1;
                int elem = arr[i];
                while(set.contains(elem+1)){
                    curr++;
                    elem++;
                }
                count = Math.max(curr, count);
            }
        }
        return count;
    }
    public static int longestConsecutive(int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        int i = 0;
        int j = i+1;
        while(j<arr.length){
            boolean flag = false;
            int curr_count = 1;
            while(j<arr.length && arr[j]==arr[i]+1) {
                flag = true;
                curr_count += 1;
                i++;
                j++;
                while(j<arr.length && arr[j-1]==arr[j]){j++;i++;}
            }
            if(!flag) {i++;j++;}
            //while(j<arr.length && arr[j-1]==arr[j]){j++;i++;}
            count = Math.max(curr_count, count);
        }
        return count;
    }
}
