class Solution {
    public int solution(int n) {
        int size = (int) Math.sqrt(n);
        int sum = 0;
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