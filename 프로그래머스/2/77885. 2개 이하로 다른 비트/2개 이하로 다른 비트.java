class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] result = new long[len];
        
        for(int i = 0; i < len; i++) {
            long x = numbers[i];
            if(x % 2 == 0) {
                result[i] = x + 1;
            } else {
                long bit = 1;
                while((x & bit) != 0) {
                    bit <<= 1;
                }
                result[i] = x + bit - (bit >> 1);
            }
        }
        
        return result;
    }
}