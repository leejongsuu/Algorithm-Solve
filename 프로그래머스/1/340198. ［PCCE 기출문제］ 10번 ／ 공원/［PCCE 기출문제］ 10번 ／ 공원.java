import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        int row = park.length;
        int col = park[0].length;
        
        Arrays.sort(mats);
        
        for(int m = mats.length - 1; m >= 0; m--) {
            int size = mats[m];
            for(int i = 0; i <= row - size; i++) {
                for(int j = 0; j <= col - size; j++) {
                    if(canPlace(i, j, size, park)) {
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean canPlace(int y, int x, int size, String[][] park) {
        
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        
        return true;
    }
}