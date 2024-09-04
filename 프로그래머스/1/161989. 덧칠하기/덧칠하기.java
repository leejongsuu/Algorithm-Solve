class Solution {
    public int solution(int n, int m, int[] section) {
        
        int result = 0;
        int pos = 0;
        
        for(int sect : section) {
            if(sect > pos) {
                result++;
                pos = sect + m - 1;
            }
        }
        
        return result;
    }
}