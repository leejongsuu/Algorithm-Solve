import java.util.Arrays;

class Solution {
    
    public int solution(int[] mats, String[][] park) {
        
        int row = park.length;
        int col = park[0].length;
        int maxSize = -1;
        
        Arrays.sort(mats);
        
        for(int m = mats.length - 1; m >= 0; m--) {
            
            for(int i = 0; i <= row - mats[m]; i++) {
                boolean flag = false;
                for(int j = 0; j <= col - mats[m]; j++) {
                    if(canPlace(i, j, mats[m], park)) {
                        flag = true;
                        break;
                    }
                }
                
                if(flag) {
                    return mats[m];
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