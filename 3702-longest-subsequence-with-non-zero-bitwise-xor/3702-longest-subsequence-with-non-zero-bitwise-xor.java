// class Solution {
//     public int longestSubsequence(int[] nums) {
//         int prev = nums[0];
//         int count = 1;
//         for(int i=1;i<nums.length;i++){
//             if((prev^nums[i])!=0){
//                 prev ^= nums[i];
//                 count++;
//             }
//             else{
//                 prev = nums[i];
//             }
//         }
//         if(count==1){
//             return 0;
//         }
//         return count;
//     }
// }
class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean nonZero = false;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                nonZero = true;
            }
        }

        if (xor != 0) {
            return nums.length;
        }

        if (nonZero) {
            return nums.length - 1;
        }

        return 0;
    }
}