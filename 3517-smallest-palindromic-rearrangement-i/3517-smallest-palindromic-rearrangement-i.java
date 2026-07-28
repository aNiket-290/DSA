class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];

        for (int i = 0; i < n / 2; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        // Left half
        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                ans.append((char) (i + 'a'));
            }
        }

        // Middle character (if odd length)
        if (n % 2 == 1) {
            ans.append(s.charAt(n / 2));
        }

        // Right half (reverse of left half)
        for (int i = n / 2 - 1; i >= 0; i--) {
            ans.append(ans.charAt(i));
        }

        return ans.toString();
    }
}