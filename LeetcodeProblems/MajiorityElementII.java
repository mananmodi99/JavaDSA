package LeetcodeProblems;
//Problem Link: https://leetcode.com/problems/majority-element-ii
public class MajiorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int num1 = -1, num2 = -1, count1= 0, count2 = 0;
        for(int i = 0; i<nums.length; i++){
            if(num1 == nums[i]) count1++;
            else if(num2 == nums[i]) count2++;
            else if(count1 == 0){
                count1 = 1;
                num1 = nums[i];
            }
            else if(count2 == 0){
                count2 = 1;
                num2 = nums[i];
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == num1) count1++;
            if(nums[i] == num2) count2++;
        }
        if(count1>nums.length/3 && num1!=num2) list.add(num1);
        if(count2>nums.length/3) list.add(num2);
        return list;
    }
    public List<Integer> Better(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue()>nums.length/3)
                list.add(e.getKey());
        }
        return list;
    }
}
