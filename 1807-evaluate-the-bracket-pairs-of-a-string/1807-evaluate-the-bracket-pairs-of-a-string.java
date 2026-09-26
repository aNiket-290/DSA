class Solution {
    public String evaluate(String s, List<List<String>> k) {
        HashMap<String, String> map = new HashMap<>();
        for(int i=0;i<k.size();i++){
            map.put(k.get(i).get(0),k.get(i).get(1));
        }

        String ans = "";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' && i<s.length()){
                i = i+1;
                String key = "";
                while(i<s.length() && s.charAt(i)!=')'){
                    key += s.charAt(i++);
                }
                ans += map.getOrDefault(key,"?");
            }
            else{
                ans += s.charAt(i);
            }
        }
        return ans;
    }
}