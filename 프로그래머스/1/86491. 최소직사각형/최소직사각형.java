class Solution {
    public int solution(int[][] sizes) {
        
        int x_len = Integer.MIN_VALUE;
        int y_len = Integer.MIN_VALUE;
        
        for(int[] size : sizes) {
            x_len = Math.max(x_len, Math.max(size[0], size[1]));
            y_len = Math.max(y_len, Math.min(size[0], size[1]));
        }
        
        return x_len * y_len;
    }
}