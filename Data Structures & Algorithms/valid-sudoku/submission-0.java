class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char num = board[i][j];

                if (num == '.') {
                    continue;
                }

                if (!set.add(num + " added in row " + i)
                    || !set.add(num + " added in col " + j)
                    || !set.add(num + " added in box " + i / 3 + "," + j / 3)) {

                    return false;
                }
            }
        }

        return true;
    }
}