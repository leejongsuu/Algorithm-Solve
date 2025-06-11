class Solution {
     
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int n = queries.length;
        int[] answer = new int[n];
        
        int[][] arr = new int[rows][columns];
        for(int num = 0, i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                arr[i][j] = ++num;
            }
        }
        
        for(int i = 0; i < n; i++) {
            int y1 = queries[i][0] - 1;
            int x1 = queries[i][1] - 1;
            int y2 = queries[i][2] - 1;
            int x2 = queries[i][3] - 1;

            answer[i] = rotate(y1, x1, y2, x2, arr);
        }
        
        return answer;
    }
    
    int rotate(int y1, int x1, int y2, int x2, int[][] arr) {
        int before = arr[y1][x1];
        int min = before;
        
        for(int i = x1 + 1; i <= x2; i++) {
            int temp = arr[y1][i];
            arr[y1][i] = before;
            before = temp;
            min = Math.min(min, before);
        }
        
        for(int i = y1 + 1; i <= y2; i++) {
            int temp = arr[i][x2];
            arr[i][x2] = before;
            before = temp;
            min = Math.min(min, before);
        }
        
        for(int i = x2 - 1; i >= x1; i--) {
            int temp = arr[y2][i];
            arr[y2][i] = before;
            before = temp;
            min = Math.min(min, before);
        }
        
        for(int i = y2 - 1; i >= y1; i--) {
            int temp = arr[i][x1];
            arr[i][x1] = before;
            before = temp;
            min = Math.min(min, before);
        }
        
        return min;
    }
}