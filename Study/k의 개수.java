class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int u = i; u <= j; u++) {
            for(char c : String.valueOf(u).toCharArray()) {
                if((c - '0') == k) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
