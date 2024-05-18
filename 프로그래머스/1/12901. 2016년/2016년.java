class Solution {
    public String solution(int a, int b) {
        int[] date = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        for(int i = 0; i < a; i++) {
            b += date[i];
        }
        b -=1;
        return week[b % 7];
    }
}