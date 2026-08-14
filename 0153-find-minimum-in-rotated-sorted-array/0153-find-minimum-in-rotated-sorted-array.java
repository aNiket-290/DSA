class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = 5000;

        while (left <= right) {
            min = Math.min(min,Math.min(nums[left],nums[right]));
            int mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);

            // Step 2: Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target lies within the sorted left half
                if (min >= nums[left] && min < nums[mid]) {
                    right = mid - 1; // Search left
                } else {
                    left = mid + 1;  // Search right
                }
            } 
            // Step 3: Otherwise, the right half must be sorted
            else {
                // Check if target lies within the sorted right half
                if (min > nums[mid] && min <= nums[right]) {
                    left = mid + 1;  // Search right
                } else {
                    right = mid - 1; // Search left
                }
            }
        }
        return min;
    }
}