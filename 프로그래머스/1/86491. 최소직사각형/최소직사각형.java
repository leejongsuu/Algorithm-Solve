class Solution {
    public int solution(int[][] sizes) {
        
        int max = 0;
        int min = 0;
        for(int[] size : sizes) {
            int max_temp = Math.max(size[0], size[1]);
            int min_temp = Math.min(size[0], size[1]);
            
            max = Math.max(max, max_temp);
            min = Math.max(min, min_temp);
        }
        
        return max * min;
    }
}