// class Solution {
//     public int reverseBits(int n) {
//         List<Integer> bits = new ArrayList<>();
//         int x=n;
//         int count = 0;
//         while(x>0){
//             bits.add(x%2);
//             x/=2;
//         }
//         int ans=0;
//         for(int i=0;i<bits.size();i++){
//             ans += bits.get(i)*Math.pow(2,31-i);
//         }
//         return ans;
//     }
// }
class Solution {
    public int reverseBits(int n) {

        int ans = 0;

        for (int i = 0; i < 32; i++) {

            int bit = n & 1;

            ans = (ans << 1) | bit;

            n >>= 1;
        }

        return ans;
    }
}