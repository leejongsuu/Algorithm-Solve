class Solution {
    public int solution(int left, int right) {
        int result = 0;
        for(int i = left; i <= right; i++) {
            int count = getDivisorCount(i);
            result += count % 2 == 0 ? i : i * -1;
        }
        return result;
    }
    
    public int getDivisorCount(int num) {
        int count = 0;
        for(int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                count++;
                if(num / i != i) count++;
            }
        }
        return count;
    }
}