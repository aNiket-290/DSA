class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int ans = nums[0];
        int max = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (count > max) {
                    max = count;
                    ans = nums[i - 1];
                }
                count = 1;
            } else {
                count++;
                if (count > max) {
                    max = count;
                    ans = nums[i];
                }
            }
        }

        return ans;
    }
}