class Solution {
    public int solution(int n, int w, int num) {
        // 전체 층 수
        int totalRows = (n - 1) / w + 1;
        // num의 위치
        int row = (num - 1) / w;
        int col;

        // num이 위치한 열 (지그재그 고려)
        if (row % 2 == 0) {
            // 왼 → 오
            col = (num - 1) % w;
        } else {
            // 오 → 왼
            col = w - 1 - (num - 1) % w;
        }

        int count = 1; // 자신 포함

        // 위층만 조사
        for (int r = row + 1; r < totalRows; r++) {
            int boxIdx;
            if (r % 2 == 0) {
                // 왼 → 오
                boxIdx = r * w + col;
            } else {
                // 오 → 왼
                boxIdx = (r + 1) * w - 1 - col;
            }

            if (boxIdx >= n) break;
            count++;
        }

        return count;
    }
}
