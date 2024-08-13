class Solution {
    public int solution(int num) {
        
        int cnt = 0;
        long result = num;
        while(cnt < 500) {
            if(result == 1) {
                return cnt;
            } else if(result % 2 == 0) {
                result /= 2;
            } else {
                result = 3 * result + 1;
            }
            cnt++;
        }
        
        return -1;
    }
}