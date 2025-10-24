class Solution {
    
    int N, M;
    
    public boolean solution(int[][] key, int[][] lock) {
        
        N = lock.length;
        M = key.length;
        
        int P = M - 1;
        int newSize = N + 2 * P;
        int[][] expLock = new int[newSize][newSize];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                expLock[i + P][j + P] = lock[i][j];
            }
        }
        
        for(int d = 0 ; d < 4; d++) {
            key = rotateKey(key);
            
            for(int i = 0; i < N + P; i++) {
                for(int j = 0; j < N + P; j++) {
                    if(check(i, j, P, key, expLock)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    
    public boolean check(int r, int c, int size, int[][] key, int[][] expLock) {
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                expLock[r + i][c + j] += key[i][j];
            }
        }
        
        boolean isLocked = true;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(expLock[i + size][j + size] != 1) {
                    isLocked = false;
                    break;
                }
            }
            if(!isLocked) break;
        }
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                expLock[r + i][c + j] -= key[i][j];
            }
        }
        
        return isLocked;
    }
    
    public int[][] rotateKey(int[][] key) {
        int[][] newKey = new int[M][M];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                newKey[i][j] = key[j][M - (i + 1)];
            }
        }
        
        return newKey;
    }
}