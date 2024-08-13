class Solution {
    public int solution(int n) {
        
        int sum = 0;
        
        int size = (int) Math.sqrt(n);
        for(int i = 1; i <= size; i++) {
            if(n % i == 0) {
                sum += i;
                sum += n / i;
            }
        }
        
        if(size * size == n) {
            sum -= size;
        }
        
        return sum;
    }
}