class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean ans = false;
        for(int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])) {
                ans = true;
                break;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}