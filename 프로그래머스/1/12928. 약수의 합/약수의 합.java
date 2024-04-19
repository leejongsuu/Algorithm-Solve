class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
            // 약수 찾기
            if(n % i == 0) answer += i;
        }
        return answer;
    }
}