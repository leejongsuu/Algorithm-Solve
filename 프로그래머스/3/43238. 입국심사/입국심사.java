import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times); // 심사 시간을 오름차순으로 정렬
        
        long left = 0;
        long right = (long) times[times.length - 1] * n; // 최대 걸리는 시간

        long answer = right;
        while (left <= right) {
            long mid = (left + right) / 2; // 중간값을 기준으로 이분 탐색
            
            long total = 0;
            for (int time : times) {
                total += mid / time; // 각 심사관이 mid 시간 동안 심사할 수 있는 사람 수를 더함
            }

            if (total >= n) { // 심사할 수 있는 사람 수가 n보다 크거나 같으면
                answer = Math.min(answer, mid); // 최솟값 갱신하고 범위를 왼쪽으로 좁힘
                right = mid - 1;
            } else { // 심사할 수 있는 사람 수가 n보다 작으면
                left = mid + 1; // 범위를 오른쪽으로 좁힘
            }
        }

        return answer;
    }
}
