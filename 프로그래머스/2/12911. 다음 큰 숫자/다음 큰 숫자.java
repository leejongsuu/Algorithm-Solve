class Solution {
    public int solution(int n) {
        
        final int inf = getOneCount(n);
        
        while(true) {
            n++;
            if(inf == getOneCount(n)) {
                return n;
            }
        }
    }
    
    private int getOneCount(int n) {
        String str = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}