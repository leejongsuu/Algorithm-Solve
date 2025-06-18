class Solution {
    public long solution(long w, long h) {
        // 대각선이 지나가면서 사용 못 하는 정사각형 수
        // = w + h - gcd(w, h)
        long g = gcd(w, h);
        long unusable = w + h - g;
        // 전체 칸 수에서 빼기
        return w * h - unusable;
    }

    // 최대공약수 (유클리드 호제법)
    private long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
