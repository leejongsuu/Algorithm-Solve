class Solution {
    public String solution(int a, int b) {
        
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        for(int i = 0; i < a; i++) {
            b += month[i];
        }
        
        b -= 1;
        
        return day[b % 7];
    }
}