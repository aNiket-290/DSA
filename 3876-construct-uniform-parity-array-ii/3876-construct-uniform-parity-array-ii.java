class Solution {
    public boolean uniformArray(int[] nums1) {

        int minOdd = Integer.MAX_VALUE;

        // Find smallest odd
        for (int x : nums1) {
            if (x % 2 == 1) {
                minOdd = Math.min(minOdd, x);
            }
        }

        // No odd number -> all are even
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Every even number must be >= minOdd
        for (int x : nums1) {
            if (x % 2 == 0 && x < minOdd) {
                return false;
            }
        }

        return true;
    }
}