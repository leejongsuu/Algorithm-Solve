class Solution {
    public int[] solution(String s) {
        
        int[] result = new int[2];
        
        while(s.length() > 1) {
            
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    result[1]++;
                }
            }
            
            int tempLength = s.replaceAll("0", "").length();
            s = Integer.toBinaryString(tempLength);
            
            result[0]++;
        }
        
        return result;
    }
}