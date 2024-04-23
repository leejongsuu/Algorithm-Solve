class Solution {
    public int solution(int[] numbers) {
        int answer = 9 * (10) / 2;
        for(int i : numbers) {
            answer -= i;
        }
        return answer;
    }
}