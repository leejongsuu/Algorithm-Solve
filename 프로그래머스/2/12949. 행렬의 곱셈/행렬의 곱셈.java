class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int row_len = arr1.length;
        int col_len = arr2[0].length;
        
        int[][] result = new int[row_len][col_len];
        
        for(int i = 0; i < row_len; i++) {
            for(int j = 0; j< col_len; j++) {
                for(int k = 0; k < arr1[i].length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return result;
    }
}