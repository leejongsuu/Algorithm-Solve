import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        int[] answer = new int[n];
        
        long remain = k - 1;
        
        for(int pos = 0; pos < n; pos++) {
            int size = n - pos;
            long blockSize = fact[size - 1];
            
            int idx = (int) (remain / blockSize);
            answer[pos] = numbers.get(idx);
            
            numbers.remove(idx);
            remain %= blockSize;
        }
        
        return answer;
        
    }
}