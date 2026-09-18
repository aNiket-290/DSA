// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         for (int i = 0; i < matrix.length; i++) {
//             if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length-1]) {
//                 int l = 0, r = matrix[0].length - 1;
//                 while (l < r) {
//                     int mid = l + (r - l) / 2;
//                     if (target == mid || target == l || target == r) {
//                         return true;
//                     } else if (target < mid) {
//                         r = mid - 1;
//                     } else {

//                         l = mid + 1;
//                     }

//                 }
//             }
//         }
//         return false;
//     }
// }
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return false;
    }
}