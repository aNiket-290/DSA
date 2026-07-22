class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        boolean ans = false;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=k ) {
                ans = true;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;

    }
}