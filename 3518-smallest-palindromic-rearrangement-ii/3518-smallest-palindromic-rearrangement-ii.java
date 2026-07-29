class Solution {

    public String smallestPalindrome(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int[] half = new int[26];
        StringBuilder mid = new StringBuilder();
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
            halfLen += half[i];
            if ((cnt[i] & 1) == 1) {
                mid.append((char) ('a' + i));
            }
        }

        long total = countWays(half, halfLen, k);
        if (total < k) return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {

                if (half[c] == 0) continue;

                half[c]--;

                long ways = countWays(half, halfLen - pos - 1, k);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                }

                k -= ways;
                half[c]++;
            }
        }

        StringBuilder ans = new StringBuilder(left);
        ans.append(mid);

        for (int i = left.length() - 1; i >= 0; i--) {
            ans.append(left.charAt(i));
        }

        return ans.toString();
    }

    private long countWays(int[] freq, int len, long limit) {

        long res = 1;
        int remaining = len;

        for (int c = 0; c < 26; c++) {

            int f = freq[c];
            if (f == 0) continue;

            res *= nCrLimited(remaining, f, limit);

            if (res >= limit) return limit;

            remaining -= f;
        }

        return res;
    }

    private long nCrLimited(int n, int r, long limit) {

        if (r > n) return 0;

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {

            long num = n - r + i;
            long den = i;

            long g = gcd(num, den);
            num /= g;
            den /= g;

            g = gcd(ans, den);
            ans /= g;
            den /= g;

            if (ans > limit / num) return limit;

            ans *= num;

            ans /= den;

            if (ans >= limit) return limit;
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}