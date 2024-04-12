class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        for(int i=1; i<= yellow/2+1; i++) {
            if(yellow % i == 0) {
                int x = yellow / i;
                int y = i;
                int total = (x+2) * 2 + y * 2;
                if(total == brown) {
                    answer[0] = x+2;
                    answer[1] = y+2;
                    break;
                }
            } 
        }
        
        return answer;
    }
}