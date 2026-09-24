class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int sum = 0;
            while (x > 0) {
                sum = sum + x % 10;
                x = x / 10;
            }
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
}