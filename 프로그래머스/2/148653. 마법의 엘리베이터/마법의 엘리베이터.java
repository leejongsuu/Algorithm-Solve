class Solution {
    public int solution(int storey) {
        int result = 0;
        
        while(storey > 0) {
            int rem = storey % 10;
            int q = storey / 10;

            if(rem < 5) {
                result += rem;
            } else if (rem > 5) {
                result += 10 - rem;
                q += 1;
            } else {
                result += rem;
                int temp = q % 10;
                if(temp >= 5) {
                    q += 1;
                }
            }
            
            storey = q;
        }
        
        return result;
    }
}