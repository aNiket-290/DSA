class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> num= new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int n=nums.length;
        int min=nums[0];
        int max=nums[0];
        for(int i=0;i<n;i++){
            num.add(nums[i]);
            if(nums[i]<min) min=nums[i];
            if(nums[i]>max) max=nums[i];
        }

        for(int i=min+1;i<max;i++){
            if(!num.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}