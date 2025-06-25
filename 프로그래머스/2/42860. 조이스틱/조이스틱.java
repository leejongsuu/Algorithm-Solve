class Solution {
    public int solution(String name) {
        
        int result = 0;
        int len = name.length();
        int move = len - 1;
        
        for(int i = 0; i < len; i++) {
            // 1) 위/아래 이동
            result += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // 2) 좌/우로 이동
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, i * 2 + len - next);
            move = Math.min(move, (len - next) * 2 + i);
        }

        return result + move;
    }
}