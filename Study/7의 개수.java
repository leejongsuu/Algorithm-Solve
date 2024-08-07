import java.util.ArrayList;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>();
        for(int n : array) {
            list.add(String.valueOf(n));
        }
        
        for(String s : list) {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '7') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
