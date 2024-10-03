class Solution {
    public int[] solution(int brown, int yellow) {
        
        int sqrt = (int) Math.sqrt(yellow);
        
        for(int row = 1; row <= sqrt; row++) {
            if(yellow % row == 0) {
                int col = yellow / row;
                
                if(((row * 2 + 4) + col * 2) == brown) {
                    return new int[]{col + 2, row + 2};
                }
            }
        }
        
        return new int[]{-1, -1};
    }
}