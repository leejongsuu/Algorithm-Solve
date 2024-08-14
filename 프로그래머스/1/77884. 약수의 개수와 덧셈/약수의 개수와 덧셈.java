class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        
        for(int i = left; i <= right; i++) {
            int count = getDivisorCount(i);
            if(count % 2 == 0) sum += i;
            else sum -= i;
        }
        
        return sum;
    }
    
    public int getDivisorCount(int num) {
        
        int count = 0;
        int sqrt = (int) Math.sqrt(num);
        
        for(int i = 1; i <= sqrt; i++) {
            if(num % i == 0) {
                count += 2;
            } 
        }
        
        if(sqrt * sqrt == num) {
            count--;
        }
        
        return count;
    }
}