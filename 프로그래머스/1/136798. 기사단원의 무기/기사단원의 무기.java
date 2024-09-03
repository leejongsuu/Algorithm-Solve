class Solution {
    public int solution(int number, int limit, int power) {
        
        int result = 0;
        for(int i = 1; i <= number; i++) {
            int count = getDivisor(i);
            if(count > limit) {
                result += power;
            } else {
                result += count;
            }
        }
        return result;
    }
    
    private int getDivisor(int num) {
        
        int count = 0;
        int len = (int) Math.sqrt(num);
        
        for(int i = 1; i <= len; i++) {
            if(num % i == 0) {
                count++;
            }
        }
        
        count *= 2;
        if(len * len == num) {
            count -= 1;
        }
        
        return count;
    }
}