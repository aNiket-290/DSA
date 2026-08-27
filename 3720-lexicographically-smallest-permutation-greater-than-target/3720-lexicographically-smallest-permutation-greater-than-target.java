class Solution {

    private String getMinString(int[] freq) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                res.append((char) ('a' + i));
            }
        }

        return res.toString();
    }

    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        // Characters available in s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Remove characters of target
        for (char c : target.toCharArray()) {
            freq[c - 'a']--;
        }

        // Backtrack from right to left
        for (int i = s.length() - 1; i >= 0; i--) {

            int b = target.charAt(i) - 'a';

            // Put target[i] back
            freq[b]++;

            // Check whether all frequencies are valid
            boolean valid = true;

            for (int k = 0; k < 26; k++) {
                if (freq[k] < 0) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                continue;
            }

            // Try the smallest character greater than target[i]
            for (int j = b + 1; j < 26; j++) {

                if (freq[j] > 0) {

                    freq[j]--;

                    // Keep target's prefix and change position i
                    StringBuilder ans = new StringBuilder();

                    ans.append(target.substring(0, i));
                    ans.append((char) ('a' + j));

                    // Add remaining characters in sorted order
                    ans.append(getMinString(freq));

                    return ans.toString();
                }
            }
        }

        return "";
    }
}