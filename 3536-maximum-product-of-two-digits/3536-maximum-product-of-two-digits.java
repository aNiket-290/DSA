class Solution {
    public int maxProduct(int n) {
        int first =0;
        int secmax =0;
        while(n>0){
            int x=n%10;
            if(x>first){
                secmax = first;
                first = x;
            }
            else if(x>secmax){
                secmax = x;
            }
            n = n/10;
        }
        return first*secmax;
    }
}