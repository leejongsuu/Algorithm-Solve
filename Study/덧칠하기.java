class Solution {
    public int solution(int n, int m, int[] section) {
        
        int count = 1;
        int painted = section[0] + m;
        for(int i = 1; i < section.length; i++) {
            if(section[i] >= painted) {
                count++;
                painted = section[i] + m;
            }
        }
        
        return count;
    }
}
