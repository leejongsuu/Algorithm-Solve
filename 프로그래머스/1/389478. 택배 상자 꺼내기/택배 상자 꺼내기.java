class Solution {
    public int solution(int n, int w, int num) {
        int totalRows = (n - 1) / w + 1;
        int row = (num - 1) / w;

        int col;
        if(row % 2 == 0) {
            col = (num - 1) % w;
        } else {
            col = w - 1 - (num - 1) % w;
        }
        
        int result = 1;
        for(int r = row + 1; r < totalRows; r++) {
            int boxId;
            if(r % 2 == 0) {
                boxId = r * w + col;
            } else {
                boxId = (r + 1) * w - col - 1;
            }
            if(boxId >= n) {
                break;
            }
            result++;
        }
        
        return result;
    }
}