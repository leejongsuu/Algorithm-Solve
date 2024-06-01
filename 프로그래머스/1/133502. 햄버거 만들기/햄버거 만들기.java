class Solution {
    public int solution(int[] ingredient) {
        
        int answer = 0;
        int len = ingredient.length;
        int[] stack = new int[len];
        int pos = 0;
        for(int n : ingredient) {
            stack[pos++] = n;
            if(pos > 3) {
                if(stack[pos - 1] == 1 && stack[pos - 2] == 3 && stack[pos - 3] == 2 && stack[pos - 4] == 1) {
                    answer++;
                    pos -= 4;
                }
            }
        }
        
        return answer;
    }
}