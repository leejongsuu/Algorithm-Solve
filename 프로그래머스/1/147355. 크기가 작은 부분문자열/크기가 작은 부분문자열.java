class Solution {
    public int solution(String t, String p) {
        
        int count = 0;
        
        for(int lt = 0, rt = p.length(); rt <= t.length(); lt++, rt++) {
            String numStr = t.substring(lt, rt);
            if(numStr.compareTo(p) <= 0) {
                count++;
            }
        }
        
        return count;
    }
}