class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MIN_VALUE;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (list.size() < m * n) {
            // Move from left to right along the top row
            for (int j = left; j <= right; j++) {
                if (matrix[top][j] != min) {
                    list.add(matrix[top][j]);
                    matrix[top][j] = min;
                }
            }
            top++;

            // Move from top to bottom along the rightmost column
            for (int i = top; i <= bottom; i++) {
                if (matrix[i][right] != min) {
                    list.add(matrix[i][right]);
                    matrix[i][right] = min;
                }
            }
            right--;

            // Move from right to left along the bottom row
            for (int j = right; j >= left; j--) {
                if (matrix[bottom][j] != min) {
                    list.add(matrix[bottom][j]);
                    matrix[bottom][j] = min;
                }
            }
            bottom--;

            // Move from bottom to top along the leftmost column
            for (int i = bottom; i >= top; i--) {
                if (matrix[i][left] != min) {
                    list.add(matrix[i][left]);
                    matrix[i][left] = min;
                }
            }
            left++;
        }

        return list;
    }
}
