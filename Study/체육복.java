class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 학생들의 체육복 상태를 나타내는 배열 초기화
        int[] result = new int[n+2];
        for (int i : lost) result[i]--;
        for (int i : reserve) result[i]++;
        
        // 체육복 빌려주기 처리
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (result[i] < 0) {
                if (result[i-1] > 0) {
                    result[i-1]--;
                    result[i]++;
                } else if (result[i+1] > 0) {
                    result[i+1]--;
                    result[i]++;
                }
            }
            
            // 체육수업에 참여할 수 있는 학생 수 계산
            if (result[i] >= 0) answer++;
        }
        
        return answer;
    }
}
