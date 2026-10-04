class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                low++;
                high++;
            } 
            else if (ch == ')') {
                low--;
                high--;
            } 
            else { // '*'
                low--;     // '*' acts as ')'
                high++;    // '*' acts as '('
            }

            // Minimum cannot be negative
            low = Math.max(low, 0);

            // Even maximum is negative -> impossible
            if (high < 0) {
                return false;
            }
        }

        return low == 0;
    }
}