class Solution {
    public int solution(int[][] sizes) {
        
        int maxH = 0 , maxW = 0;
        
        for(int[] size : sizes) {
            int min = Math.min(size[0], size[1]);
            int max = Math.max(size[0], size[1]);
            
            maxH = Math.max(maxH, min);
            maxW = Math.max(maxW, max);
        }
        
        return maxH * maxW;
    }
}