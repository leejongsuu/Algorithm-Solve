class Solution {
    public int solution(int n, int m, int[] section) {
        
        int count = 0;
        
        boolean[] brick = new boolean[n + 1];
        for(int i : section) {
            brick[i] = true;
        }
        
        for(int i = 1; i <= n; i++) {
            
            if(brick[i]) {
                count ++;
                int j = i;
                for(; j < i + m; j++) {
                    if(j > n) break;
                    brick[j] = false;
                }
                i = j - 1;
            }
        }
        
        return count;
    }
}