
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int sz = row * col;

        k = k % sz;

        // Initialize the 2D list for the answer
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                subList.add(0); // Fill with dummy values to simulate grid sizing
            }
            ans.add(subList);
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int newIndex = i * col + j + k;
                int newRow = (newIndex / col) % row;
                int newCol = newIndex % col;

                ans.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return ans;
    }
}