class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int rows = matrix.length;

        int s = 0, e = cols * rows - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            int row = m / cols;
            int col = m % cols;

            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] > target) {
                e = m - 1;
            }
            else {
                s = m + 1;
            }
        }

        return false;
    }
}
