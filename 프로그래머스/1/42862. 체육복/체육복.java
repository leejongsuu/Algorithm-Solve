class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int result = n;
        int[] clothes = new int[n+2];
        
        for(int number : lost) {
            clothes[number]--;
        }
        
        for(int number : reserve) {
            clothes[number]++;
        }
        
        for(int i = 1; i <= n; i++) {
            if(clothes[i] < 0) {
                if(clothes[i-1] > 0) {
                    clothes[i-1]--;
                } else if(clothes[i+1] > 0) {
                    clothes[i+1]--;
                } else {
                    result--;
                }
            }
        }
        
        return result;
    }
}