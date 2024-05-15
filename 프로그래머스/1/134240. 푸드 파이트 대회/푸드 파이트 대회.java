class Solution {
    public String solution(int[] food) {
        String answer = "0";
        for(int i = food.length - 1; i > 0; i--) {
            for(int j = food[i] / 2; j > 0; j--) {
                answer = i + answer + i;
            }
        }
        return answer;
    }
}