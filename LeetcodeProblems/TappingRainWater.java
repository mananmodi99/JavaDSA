package LeetcodeProblems;

public class TappingRainWater {
    public int trap(int[] arr) {
        int lo = 0, hi = arr.length-1;
        int l_max = 0, r_max = 0, res = 0;
        while(lo<hi){
            if(arr[lo]<=arr[hi]){
                if(arr[lo]>=l_max){
                    l_max = arr[lo];
                }
                else{
                    res += (l_max-arr[lo]);
                }
                lo++;
            }
            else{
                if(arr[hi]>=r_max){
                    r_max = arr[hi];
                }
                else{
                    res += r_max-arr[hi];
                }
                hi--;
            }
        }
        return res;
    }
    public int better(int[] height) {
        int left[] = new int[height.length];
        int right[] = new int[height.length];

        int curr_max = 0;
        for(int l = 0; l<height.length; l++){
            curr_max = Math.max(curr_max, height[l]);
            left[l] = curr_max;
        }

        curr_max = 0;
        for(int r = height.length-1; r>=0; r--){
            curr_max = Math.max(curr_max, height[r]);
            right[r] = curr_max;
        }

        int sum = 0;
        for(int i = 0; i<height.length; i++){
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }
}
