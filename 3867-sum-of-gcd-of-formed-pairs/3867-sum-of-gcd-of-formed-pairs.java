class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int [] prefixGcd = new int [n];
        int max = 0;
        long sum = 0;
        for(int i=0;i<n;i++){
            max = Math.max(nums[i],max);
            prefixGcd[i] = gcd(nums[i], max);
        }
        Arrays.sort(prefixGcd);
        int left = 0;
        int right = n-1;
        while(left<right){
            sum +=gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return sum;
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // Handles negative inputs safely
    }
    
}