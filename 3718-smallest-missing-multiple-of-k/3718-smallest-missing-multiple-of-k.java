class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(nums[i]%k==0){
                set.add(nums[i]);
            }
        }
        for(int i=1;i<=set.size()+1;i++){
            if(!set.contains(i*k)) return i*k;
        }
        return 0;
    }
}