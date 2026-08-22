class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum=0;
        int product=1;
        while(temp>0){
            int x = temp%10;
            sum+=x;
            product*=x;
            temp/=10;
        }
        if(n%(sum+product)==0){
            return true;
        }
        return false;
    }
}