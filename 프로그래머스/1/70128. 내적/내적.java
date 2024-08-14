class Solution {
    public int solution(int[] a, int[] b) {
        
        int sum = 0;
        
        int len = a.length;
        for(int i = 0; i < len; i++) {
            sum += a[i] * b[i];
        }
        
        return sum;
    }
}