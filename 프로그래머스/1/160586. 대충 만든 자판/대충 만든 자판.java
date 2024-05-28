import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        final int INF = 101;
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, INF);
        
        for(String key : keymap) {
            int len = key.length();
            for(int i = 0; i < len; i++) {
                int index = key.charAt(i) - 'A';
                alphabet[index] = Math.min(alphabet[index], i + 1);
            }
        }
        
        int len = targets.length;
        int[] result = new int[len];
        for(int i = 0; i < len; i++) {
            int target_len = targets[i].length();
            int sum = 0;
            for(int j = 0; j < target_len; j++) {
                int index = targets[i].charAt(j) - 'A';
                if(alphabet[index] == INF) {
                    sum = -1;
                    break;
                }
                sum += alphabet[index];
            }
            result[i] = sum;
        }
        
        return result;
    }
}