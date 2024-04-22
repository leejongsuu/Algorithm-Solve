class Solution {
    public long solution(int a, int b) {
       
        // 1부터 max까지의 합과 1부터 min-1까지의 합을 계산하여 차이를 리턴.
        return sumTo(Math.max(a,b)) - sumTo(Math.min(a,b)-1);
    }
    
    // 1부터 n까지의 합을 계산하는 메서드
    public long sumTo(long n) {
        return n * (n + 1) / 2;
    } 
}
