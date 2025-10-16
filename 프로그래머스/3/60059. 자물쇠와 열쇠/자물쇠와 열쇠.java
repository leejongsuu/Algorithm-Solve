import java.util.*;

class Solution {
    
    int M, N;
    
    public boolean solution(int[][] key, int[][] lock) {
        
        M = key.length;
        N = lock.length;

        int paddedSize = N + 2 * (M - 1);
        int[][] paddedLock = new int[paddedSize][paddedSize];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                paddedLock[i + M - 1][j + M - 1] = lock[i][j];
            }
        }
        
        for(int k = 0; k < 4; k++) {
            key = rotate(key);
            
            for(int r = 0; r <= paddedSize - M; r++) {
                for(int c = 0; c <= paddedSize - M; c++) {
                    if(check(r, c, paddedLock, key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public int[][] rotate(int[][] key) {
        int[][] newKey = new int[M][M];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                newKey[i][j] = key[j][M - (i + 1)];
            }
        }
        return newKey;
    }
    
    public boolean check(int r, int c, int[][] paddedLock, int[][] key) {
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                paddedLock[r + i][c + j] += key[i][j];
            }
        }
        
        boolean isUnlocked = true;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(paddedLock[i + M - 1][j + M - 1] != 1) {
                    isUnlocked = false; 
                    break;
                }
            }
            if(!isUnlocked) break;
        }
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                paddedLock[r + i][c + j] -= key[i][j];
            }
        }
        
        return isUnlocked;
    }
}