class Solution {
    public int solution(int n, int m, int[] section) {
        
        int count = 1;
        int roll = section[0];
        int len = section.length;
        for(int i = 1; i < len; i++) {
            if(roll + m - 1 < section[i]) {
                count++;
                roll = section[i];
            }
        }
        
        return count;
    }
}