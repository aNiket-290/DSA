class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n * n;
        int sumEven = n * (n + 1);

        int dividend = Math.max(sumOdd, sumEven);
        int remainder = Math.min(sumOdd, sumEven);

        while (remainder != 0) {
            int temp = dividend % remainder;
            dividend = remainder;
            remainder = temp;
        }

        return dividend;
    }
}