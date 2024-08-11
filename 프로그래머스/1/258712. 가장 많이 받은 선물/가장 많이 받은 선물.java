import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        int len = friends.length;
        HashMap<String, Integer> indexMap = new HashMap<>();

        for(int i = 0; i < len; i++) {
            indexMap.put(friends[i], i);
        }
        
        int[] index = new int[len];
        int[][] record = new int[len][len];
        
        for(String gift : gifts) {
            String[] splited = gift.split(" ");
            String to = splited[0];
            String from = splited[1];
            
            index[indexMap.get(to)]++;
            index[indexMap.get(from)]--;
            record[indexMap.get(to)][indexMap.get(from)]++;
        }
        
        int result = 0;
        for(int i = 0; i < len; i++) {
            int count = 0;
            for(int j = 0; j < len; j++) {
                if(i == j) continue;
                if(record[i][j] > record[j][i]) {
                    count++;
                } else if(record[i][j] == record[j][i] && index[i] > index[j]) {
                    count++;
                }
            }
            result = Math.max(result, count);
        }
        
        return result;
    }
}