
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];

        long k = (long) k1 + k2;
        int max = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }

        // Enough operations to make every difference zero
        if (k >= total) return 0;

        int low = 0, high = max;

        // Find the minimum possible maximum difference
        while (low < high) {
            int mid = low + (high - low) / 2;
            long need = 0;

            for (int d : diff) {
                if (d > mid) {
                    need += d - mid;
                }
            }

            if (need <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int level = low;
        long used = 0;
        long ans = 0;

        for (int d : diff) {
            int reduced = Math.min(d, level);
            ans += (long) reduced * reduced;

            if (d > level) {
                used += d - level;
            }
        }

        // Spend remaining operations lowering level to level - 1
        long remaining = k - used;
        ans -= remaining * (2L * level - 1);

        return ans;
    }
}
