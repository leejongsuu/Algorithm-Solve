class Solution {
    public long solution(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
       
        return add(max) - add(min - 1);
    }
    
    public long add(long n) {
        return (n * (n+1)) / 2;
    } 
}