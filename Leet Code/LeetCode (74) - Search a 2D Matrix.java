class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int maxRow = matrix.length, maxColumn = matrix[0].length;

        for (int i = 0; i < maxRow - 1; i++) {
            if (matrix[i][0] <= target && target < matrix[i + 1][0]) {
                for (int j = 0; j < maxColumn; j++) {
                    if (target == matrix[i][j]) {
                        return true;
                    }
                }
                return false;
            }
        }

        for (int i = 0; i < maxColumn; i++) {
            if (matrix[maxRow - 1][i] == target) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean a = solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 30);
        System.out.println(a);
    }
}