class Solution {
    public String solution(int a, int b) {

        int[] months = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        for(int i = 0; i < a; i++) {
            b += months[i];
        }
        
        String[] week = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        return week[(b - 1) % 7];
    }
}