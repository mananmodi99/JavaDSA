package LeetcodeProblems;
import java.util.*;
public class CountNumberOfSubarraysWithGivenXOR {
        public static void main (String[] args) {
            System.out.println(findXORCnt(new int[]{4,2,2,6,4}, 6));
        }
        public static int findXORCnt(int arr[], int target){
            int cnt = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            for(int i = 0; i<arr.length; i++){
                sum = sum^arr[i];
                if(sum == target){
                    cnt++;
                }
                int y = sum^target;
                if(map.containsKey(y)){
                    cnt+=map.get(y);
                }
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
            return cnt;
        }
}
