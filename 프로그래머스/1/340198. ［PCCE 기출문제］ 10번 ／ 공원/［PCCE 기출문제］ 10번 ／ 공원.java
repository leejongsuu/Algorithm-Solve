import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
            
        Arrays.sort(mats);
        int n = park.length;
        int m = park[0].length;
        
        for(int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(park[j][k].equals("-1")) {
                        if(checkPossible(j, k, size, park)) {
                            return size;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    public boolean checkPossible(int r, int c, int size, String[][] park) {
        int n = park.length;
        int m = park[0].length;
        
        if(r + size >  n || c + size > m) {
            return false;
        } 
        
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        
        return true;
    }
}