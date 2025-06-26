import java.util.*;

class Solution {
    private static final int SIZE = 11;
    private int maxDiff = 0;
    private int[] apeach, lion, answer;

    public int[] solution(int n, int[] info) {
        apeach = info;
        lion = new int[SIZE];
        answer = new int[]{-1};

        dfs(0, n, 0, 0);

        return answer;
    }

    private void dfs(int idx, int rem, int aScore, int lScore) {
        if (idx == SIZE) {
            // 남은 화살은 0점 과녁(10번째)에 몰아넣기
            lion[SIZE - 1] += rem;

            int diff = lScore - aScore;
            if (diff > 0) {
                // 1) 차이가 더 크면 무조건 교체
                if (diff > maxDiff) {
                    maxDiff = diff;
                    answer = lion.clone();
                }
                // 2) 차이가 같으면 “더 낮은 과녁에 더 많은 화살” 우선
                else if (diff == maxDiff) {
                    for (int i = SIZE - 1; i >= 0; i--) {
                        if (lion[i] > answer[i]) {
                            answer = lion.clone();
                            break;
                        } else if (lion[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }

            lion[SIZE - 1] -= rem;
            return;
        }

        int score = 10 - idx;
        int need  = apeach[idx] + 1;

        // 1) 라이언이 idx 점수 구간을 이기고 가기
        if (rem >= need) {
            lion[idx] = need;
            dfs(idx + 1, rem - need, aScore, lScore + score);
            lion[idx] = 0;
        }

        // 2) idx 점수 구간 스킵하기
        //    어피치가 한 발이라도 맞혔다면 aScore에 더해 준다
        int addA = (apeach[idx] > 0) ? score : 0;
        dfs(idx + 1, rem, aScore + addA, lScore);
    }
}
