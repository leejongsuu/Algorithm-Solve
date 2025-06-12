class Solution {
    public int[] solution(String[][] places) {
        
        final int size = 5;
        
        int[] result = new int[size];
        
        for(int i = 0; i < size; i++) {
            char[][] ch = new char[size][size];
            for(int j = 0; j < size; j++) {
                ch[j] = places[i][j].toCharArray();
            }
            
            result[i] = validate(ch, size) ? 1 : 0;
        }
        
        return result;
    }
    
    boolean validate(char[][] ch, int size) {
        for(int r = 0; r < size; r++) {
            for(int c = 0; c < size; c++) {
                if(ch[r][c] == 'P') {
                    if(isIn(r, c + 1, size) && ch[r][c + 1] == 'P') return false;
                    if(isIn(r + 1, c, size) && ch[r + 1][c] == 'P') return false;
                    if(isIn(r, c + 2, size) && ch[r][c + 2] == 'P')
                       if(ch[r][c + 1] != 'X') return false;
                    if(isIn(r + 2, c, size) && ch[r + 2][c] == 'P') 
                        if(ch[r + 1][c] != 'X') return false;
                    if(isIn(r - 1, c + 1, size) && ch[r - 1][c + 1] == 'P')
                        if(ch[r - 1][c] != 'X' || ch[r][c + 1] != 'X') return false;
                    if(isIn(r + 1, c + 1, size) && ch[r + 1][c + 1] == 'P')
                        if(ch[r + 1][c] != 'X' || ch[r][c + 1] != 'X') return false;
                }
            }
        }
        return true;
    }
    
    boolean isIn(int r, int c, int size) {
        return r >= 0 && c >= 0 && r < size && c < size;
    }
}