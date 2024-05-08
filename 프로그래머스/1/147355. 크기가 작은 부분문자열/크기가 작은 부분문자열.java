class Solution {
    public int solution(String t, String p) {
    
        int answer = 0;
        for(int i = 0, j = p.length(); i <= t.length() - p.length(); i++, j++) {
            if(!(t.substring(i,j).compareTo(p) > 0)) answer++;
        }
        
        return answer;
    }
}