import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int size = friends.length;
        int[][] giftArr = new int[size][size];
        int[] giftIndex = new int[size]; // 선물 지수
        
        HashMap<String, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < size; i++) {
            indexMap.put(friends[i], i);
        }
        
        for(String gift : gifts) {
            String[] splited = gift.split(" ");
            int from = indexMap.get(splited[0]);
            int to = indexMap.get(splited[1]);
            
            giftArr[from][to]++;
            giftIndex[from]++;
            giftIndex[to]--;
        }
        
        int max = 0;
        for(int i = 0; i < size; i++) {
            int gift = 0;
            
            for(int j = 0; j < size; j++) {
                if(i == j) continue;
                if(giftArr[i][j] > giftArr[j][i]) {
                    gift++;
                } else if(giftArr[i][j] == giftArr[j][i]) {
                    if(giftIndex[i] > giftIndex[j]) {
                        gift++;
                    }
                }
            }
            max = Math.max(max, gift);
        }
        
        return max;
    }
}