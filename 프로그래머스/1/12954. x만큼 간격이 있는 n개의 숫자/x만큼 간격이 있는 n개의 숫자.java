class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=0,j=1; i<n; i++,j++) {
            answer[i] = (long)x * j;
        }
        return answer;
    }
}