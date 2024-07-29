class Solution {
    public int[][] solution(int[] num_list, int n) {
        
        int m = num_list.length / n;
        int[][] result = new int[m][n];
        
        int row = 0;
        for(int i = 0; i < num_list.length; i+=n) {
            for(int j = 0; j < n; j++) {
                result[row][j] = num_list[i + j];
            }
            row++;
        }
        
        return result;
    }
}
