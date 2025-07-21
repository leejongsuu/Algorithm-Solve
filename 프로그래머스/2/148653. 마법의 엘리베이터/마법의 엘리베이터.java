class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int rem = storey % 10;
            int q = (storey / 10) % 10;
            
            if(rem < 5) {
                storey -= rem;
                answer += rem;
            } else if(rem > 5) {
                storey += 10 - rem;
                answer += 10 - rem;
            } else {
                if(q >= 5) {
                    storey += 10 - rem;
                    answer += 10 - rem;
                } else {
                    storey -= rem;
                    answer += rem;
                }
            }
            
            storey /= 10;
        }
        
        
        return answer;
    }
}