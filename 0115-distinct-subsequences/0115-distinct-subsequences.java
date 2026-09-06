class Solution {

    public int distinctSubSeq(int i, int n, int j, int m, String s, String t, int dp[][]) {
        if (j == m) {
            return 1;
        }
        if (i == n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            int take = distinctSubSeq(i + 1, n, j + 1, m, s, t, dp);
            int ntake = distinctSubSeq(i + 1, n, j, m, s, t, dp);

            return dp[i][j] = take + ntake;
        } else {
            return dp[i][j] = distinctSubSeq(i + 1, n, j, m, s, t, dp);
        }
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        return distinctSubSeq(0, n, 0, m, s, t, dp);
    }
}