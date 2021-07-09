package LeetcodeProblems;

public class MajiorityElem {
    public int Best_MooresVotingAlgo(int[] nums) {
        //TC: O(n) SC(aux):O(1)
        int count = 1, elem = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == elem) count++;
            else count--;
            if(count == 0) {count=1; elem = nums[i];}
        }
        return elem;
    }
    public int Better(int[] nums) {
        //Naive Method : O(n) Space: O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet())
        {
            if(e.getValue()>nums.length/2)
                return e.getKey();
        }
        return -1;
    }
    public int OkayOkay(int[] nums) {
        //O(n)
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
