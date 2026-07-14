class Solution {
    static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }

        int[][] dp = new int[m + 1][m + 1];
        dp[0][0] = 1;

        for (int num : nums) {
            int[][] ndp = new int[m + 1][m + 1];

            for (int s1 = 0; s1 <= m; s1++) {
                for (int s2 = 0; s2 <= m; s2++) {
                    int val = dp[s1][s2];
                    if (val == 0) continue;

                    int divisor1 = gcd(s1, num);
                    int divisor2 = gcd(s2, num);

                    // Ignore current number
                    ndp[s1][s2] = (ndp[s1][s2] + val) % MOD;

                    // Add to first subsequence
                    ndp[divisor1][s2] = (ndp[divisor1][s2] + val) % MOD;

                    // Add to second subsequence
                    ndp[s1][divisor2] = (ndp[s1][divisor2] + val) % MOD;
                }
            }

            dp = ndp;
        }

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + dp[i][i]) % MOD;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}