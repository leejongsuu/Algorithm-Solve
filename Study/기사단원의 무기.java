class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 0;
        for(int i = 1; i<= number; i++) {
            int count = getDivisorCount(i);
            if(count > limit) {
                sum += power;
            } else {
                sum += count;
            }
        }
        return sum;
    }
    
    public int getDivisorCount1(int num) {
        int count = 0;
        for(int i = 1; i <= num; i++) {
            if(num % i == 0) {
                count++;
            }
        }
        return count;
    }
    
    public int getDivisorCount2(int num) {
        int cnt = 0;
        int len = (int) Math.sqrt(num);
        for(int i = 1; i <= len; i++) {
            if(num % i == 0) {
                cnt++;
            }
        }
        
        if(len * len == num) {
            cnt = 2 * cnt - 1;
        } else {
            cnt = 2 * cnt;
        }
        return cnt;
    }
}
