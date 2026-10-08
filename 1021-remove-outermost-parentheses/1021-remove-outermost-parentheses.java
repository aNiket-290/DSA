class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                depth++;

                // Add only if this is NOT the outermost '('
                if (depth > 1) {
                    ans.append(c);
                }
            } else {
                // If depth is 1, this ')' is the outermost ')'
                if (depth > 1) {
                    ans.append(c);
                }

                depth--;
            }
        }

        return ans.toString();
    }
}