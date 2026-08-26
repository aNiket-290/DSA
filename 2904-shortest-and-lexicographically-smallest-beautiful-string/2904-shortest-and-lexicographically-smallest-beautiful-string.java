// class Solution {
//     public String shortestBeautifulSubstring(String s, int k) {
//         String ans = "";
//         int len = 101;
//         for(int i=0;i<s.length();i++){
//             int count = 0;
//             int j=i;
//             while(count<k &&j<s.length()){
//                 if(s.charAt(j)=='1'){
//                     count++;
//                 }
//                 j++;
//             }
//             if(count == k&&len>j-i){
//                 len = j-i;
//                 ans = s.substring(i,j);
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int count = 0;

        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                count++;
            }

            while (count > k) {
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }
            if (count == k) {
                while (s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);

                if (ans.equals("") ||
                    current.length() < ans.length() ||
                    (current.length() == ans.length()
                        && current.compareTo(ans) < 0)) {

                    ans = current;
                }
            }
        }

        return ans;
    }
}