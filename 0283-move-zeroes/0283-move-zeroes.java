// class Solution {
//     public void moveZeroes(int[] nums) {
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(nums[i]==0&&nums[j]!=0){
//                     nums[i] = nums[j];
//                     nums[j] = 0;
//                 }
//             }
//         }
//     }
// }
class Solution {
    public void moveZeroes(int[] nums) {
        int index =0;
        for(int i =0;i< nums.length;i++){
            if(nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
        }
        for(int i=index;i<nums.length;i++){
            nums[i]=0;
        }
    }
}