class Solution {
    
    static int[] result;
    
    public int[] solution(int[][] arr) {
        result = new int[2];
        
        if(checkSame(0, 0, arr.length, arr)) {
            increaseResult(0, 0, arr);
        } else {
            partition(0, 0, arr.length, arr);    
        }
        
        return result;
    }
    
    void partition(int r, int c, int size, int[][] arr) {
        
        int newSize = size / 2;
        
        // 2사분면
        if(checkSame(r, c, newSize, arr)) {
            increaseResult(r, c, arr);
        } else {
            partition(r, c, newSize, arr);
        }
        
        // 1사분면
        if(checkSame(r, c + newSize, newSize, arr)) {
            increaseResult(r, c + newSize, arr);
        } else {
            partition(r, c + newSize, newSize, arr);
        }
        
        // 3사분면
        if(checkSame(r + newSize, c, newSize, arr)) {
            increaseResult(r + newSize, c, arr);
        } else {
            partition(r + newSize, c, newSize, arr);
        }
        
        // 4사분면
        if(checkSame(r + newSize, c + newSize, newSize, arr)) {
            increaseResult(r + newSize, c + newSize, arr);
        } else {
            partition(r + newSize, c + newSize, newSize, arr);
        }
    }
    
    boolean checkSame(int r, int c, int size, int[][] arr) {
        int start = arr[r][c];
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(arr[i][j] != start) {
                    return false;
                }
            }
        }
        return true;
    }
    
    void increaseResult(int r, int c, int[][] arr) {
        if(arr[r][c] == 0) result[0]++;
        else result[1]++;
    }
}