class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long D = d;
        long K = k;
        long maxX = D / K; // x = 0..maxX

        long d2 = D * D;

        for (long x = 0; x <= maxX; x++) {
            long xk = x * K;
            long remain = d2 - xk * xk;
            if (remain < 0) break;  // 이후도 모두 음수이므로 탈출

            // y*k ≤ sqrt(remain)  이므로
            // y ≤ floor( sqrt(remain) / k )
            long maxY = (long) (Math.sqrt(remain) / K);
            answer += (maxY + 1); // y = 0..maxY 까지
        }

        return answer;
    }
}
