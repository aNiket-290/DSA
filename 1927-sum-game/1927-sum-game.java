class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int half = n/2;

        int ql=0,qr=0,diff=0;

        for(int i=0;i<n;i++){
            if(i<half){
                if(num.charAt(i) == '?') ++ql;
                else diff += num.charAt(i) - '0';
            }
            else{
                if(num.charAt(i) == '?') ++qr;
                else diff -= num.charAt(i) - '0';
            }
        }
        if((ql+qr)%2 == 1) return true;
        
        return diff != 9*(qr-ql)/2;
    }
}