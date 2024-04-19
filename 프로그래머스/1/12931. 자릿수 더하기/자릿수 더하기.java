public class Solution {
    public int solution(int n) {
        int answer = 0;
    
        int len = String.valueOf(n).length();
        while (n > 0) {
            int r = (int) Math.pow(10, len -1);
            answer += n / r;
            n %= r;
            len --;
        }

        return answer;
    }
}