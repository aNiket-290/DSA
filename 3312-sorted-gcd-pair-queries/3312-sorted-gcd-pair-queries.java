// class Solution {
//     public int[] gcdValues(int[] nums, long[] queries) {
//         int n = nums.length;
//         long [] gcdPairs = new long[n*(n-1)/2];
//         int k =0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 gcdPairs[k++] = gcd(nums[i],nums[j]);
//             }
//         }
//         Arrays.sort(gcdPairs);
//         int m = queries.length;
//         int [] ans = new int [m];
//         for(int i=0;i<m;i++){
//             ans[i] = (int)gcdPairs[(int)queries[i]];
//         }
//         return ans;
//     }
//     public int gcd(int a, int b) {
//         while (b != 0) {
//             int temp = b;
//             b = a % b;
//             a = temp;
//         }
//         return Math.abs(a);
//     }
// }

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }

        // Frequency of each number
        int[] freq = new int[mx + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // gcdCount[i] = number of pairs having gcd exactly i
        long[] gcdCount = new long[mx + 1];

        for (int i = mx; i >= 1; i--) {
            long cnt = 0;

            // Count numbers divisible by i
            for (int j = i; j <= mx; j += i) {
                cnt += freq[j];
            }

            // Total pairs divisible by i
            gcdCount[i] = cnt * (cnt - 1) / 2;

            // Remove pairs already counted for multiples of i
            for (int j = 2 * i; j <= mx; j += i) {
                gcdCount[i] -= gcdCount[j];
            }
        }

        // Prefix sums
        for (int i = 1; i <= mx; i++) {
            gcdCount[i] += gcdCount[i - 1];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = upperBound(gcdCount, queries[i]);
        }

        return ans;
    }

    // Returns first index where arr[index] > target
    private int upperBound(long[] arr, long target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}