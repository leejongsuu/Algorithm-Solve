class Solution {
    public int solution(int n, int m, int[] section) {
        
        int count = 1;
        int rolled = section[0];
        
        for(int i = 1; i < section.length; i++) {
            if(rolled + m - 1 < section[i]) {
                count++;
                rolled = section[i];
            }
        }
        
        return count;
    }
}