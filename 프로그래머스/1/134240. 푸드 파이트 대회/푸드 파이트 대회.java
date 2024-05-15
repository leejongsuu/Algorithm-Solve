class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            while(count > 0) {
                sb.append(i);
                count--;
            }
        }
        String answer = sb.toString() + '0' + sb.reverse().toString();
        return answer;
    }
}