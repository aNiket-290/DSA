class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> x = new Stack<>();
        for(int i=0;i<s.length();i++){
            char element = s.charAt(i);
            if(element==')'){
                char c = element;
                StringBuilder a = new StringBuilder();
                while(x.peek() != '('){
                    a.append(x.peek());
                    x.pop();
                }
                x.pop();
                for(int j=0;j<a.length();j++){
                    x.push(a.charAt(j));
                }
            }
            else{
                x.push(s.charAt(i));
            }
            
        }
        StringBuilder ans = new StringBuilder();
        for(char c : x){
            ans.append(c);
        }
        return ans.toString();
            
    }
}