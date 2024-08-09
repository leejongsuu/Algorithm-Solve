import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        // 성격 유형 배열
        char[][] kindArray = new char[][]{{'R','T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        
        // 성격 조사 결과를 담을 맵
        HashMap<Character, Integer> kindMap = new HashMap<>();
        
        for(int i = 0; i < kindArray.length; i++) {
            for(int j = 0; j < kindArray[i].length; j++) {
                kindMap.put(kindArray[i][j], 0);
            }
        }
        
        for(int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            if(choice < 4) {
                char key = survey[i].charAt(0);
                kindMap.put(key, kindMap.get(key) + (4 - choice));
            } else if(choice > 4) {
                char key = survey[i].charAt(1);
                kindMap.put(key, kindMap.get(key) + (choice - 4));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < kindArray.length; i++) {
            char a = kindArray[i][0];
            char b = kindArray[i][1];
            if(kindMap.get(a) < kindMap.get(b)) {
                sb.append(b);
            } else {
                sb.append(a);
            }
        }
        
        return sb.toString();
    }
}
