class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] result = new long[len];
        
        for (int i = 0; i < len; i++) {
            long x = numbers[i];

            // 짝수는 무조건 +1하면 비트 1개 차이
            if (x % 2 == 0) {
                result[i] = x + 1;
            } else {
                // 홀수면 0이 나오는 첫 비트 위치를 찾아서 처리
                long bit = 1;
                while ((x & bit) != 0) {
                    bit <<= 1;
                }
                // 예: 1011 -> 1101 (bit=0100, bit>>1 = 0010)
                result[i] = x + bit - (bit >> 1);
            }
        }

        return result;
    }
}
