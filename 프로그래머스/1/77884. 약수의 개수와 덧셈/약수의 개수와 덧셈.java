class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        while(left <= right) {
            int cnt = 0;
            for(int i=1; i<=left; i++) {
                if(left % i == 0) cnt++;
            }
            
            if(cnt % 2 == 0) sum += left;
            else sum -= left;
            
            left++;
        }
        
        return sum;
    }
}