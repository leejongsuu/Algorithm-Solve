class Solution {
    public int solution(String s) {
        
        int result = 0;
        
        int lCount = 0;
        int rCount = 0;
        for(int lt = 0, rt =0; rt < s.length(); rt++) {
            
            if(lt == rt) {
                lCount++;
                continue;
            }
            
            if(s.charAt(lt) == s.charAt(rt)) {
                lCount++;
            } else {
                rCount++;
            }
            
            if(lCount == rCount) {
                result++;
                lt = rt + 1;
                lCount = rCount = 0;
            }
        }
        
        if(lCount > 0) {
            result++;
        }
        
        return result;
    }
}