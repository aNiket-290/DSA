class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int maxlen = 0;
        int [] freq = new int [26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;

            while(freq[s.charAt(i)-'a']>2){
                freq[s.charAt(left++)-'a']--;
            }
            maxlen = Math.max(maxlen, i-left+1);
        }
        return maxlen;
    }
}