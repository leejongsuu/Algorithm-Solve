class Solution {
    public long[] solution(long[] numbers) {
        
        int len = numbers.length;
        
        long[] answer = new long[len];
        
        for(int i = 0; i < len; i++) {
            long number = numbers[i];
            
            if(number % 2 == 0) {
                answer[i] = number + 1;
                continue;
            }
            
            long bit = 1;
            while((bit & number) != 0) {
                bit <<= 1;
            }
             
            answer[i] = (number + bit) - (bit >> 1);
        }
        
        return answer;
    }
}