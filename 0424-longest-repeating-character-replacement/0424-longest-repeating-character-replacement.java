class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxlen = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(i) - 'A']);

            while ((i - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxlen = Math.max(maxlen, i - left + 1);
        }

        return maxlen;
    }
}