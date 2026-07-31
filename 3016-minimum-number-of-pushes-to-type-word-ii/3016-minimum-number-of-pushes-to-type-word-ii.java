class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Sort frequencies in ascending order
        Arrays.sort(freq);

        int pushes = 0;
        int index = 0;

        // Traverse from highest frequency to lowest
        for (int i = 25; i >= 0 && freq[i] > 0; i--) {
            pushes += freq[i] * (index / 8 + 1);
            index++;
        }

        return pushes;
    }
}