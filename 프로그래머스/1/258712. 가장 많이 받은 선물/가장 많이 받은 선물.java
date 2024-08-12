import java.util.HashMap;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        HashMap<String, Integer> indexMap = new HashMap<>();
        int size = friends.length;
        for(int i = 0; i < size; i++) {
            indexMap.put(friends[i], i);
        }
        
        int[] index = new int[size];
        int[][] record = new int[size][size];
        for(String gift : gifts) {
            String[] splited = gift.split(" ");
            int to = indexMap.get(splited[0]);
            int from = indexMap.get(splited[1]);
            
            index[to]++;
            index[from]--;
            record[to][from]++;
        }
        
        int max = 0;
        for(int i = 0; i < record.length; i++) {
            int count = 0;
            for(int j = 0; j < record[i].length; j++) {
                if(i == j) continue;
                if(record[i][j] > record[j][i]) count++;
                else if(record[i][j] == record[j][i] && index[i] > index[j]) count++;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}