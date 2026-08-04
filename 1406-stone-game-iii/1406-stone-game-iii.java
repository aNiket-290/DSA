class Solution {

    int n;
    int[] dp;

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int diff = solve(stoneValue, 0);

        if (diff > 0)
            return "Alice";
        else if (diff < 0)
            return "Bob";
        else
            return "Tie";
    }

    public int solve(int[] s, int i) {
        if (i >= n)
            return 0;

        if (dp[i] != Integer.MIN_VALUE)
            return dp[i];

        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int k = 0; k < 3 && i + k < n; k++) {
            sum += s[i + k];
            ans = Math.max(ans, sum - solve(s, i + k + 1));
        }

        return dp[i] = ans;
    }
}