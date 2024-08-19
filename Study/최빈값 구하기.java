import java.util.HashMap;

class Solution {
    public int solution(int[] array) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : array) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int max = -1;
        int mostFrequentValue = -1;
        boolean isUnique = true;  // 최빈값이 유일한지 확인하는 플래그
        
        for(Integer key : map.keySet()) {
            int cnt = map.get(key);
            if(cnt > max) {
                max = cnt;
                mostFrequentValue = key;
                isUnique = true;  // 새로운 최빈값이 발견되었으므로 유일함
            } else if(cnt == max) {
                isUnique = false;  // 최빈값이 여러 개일 경우
            }
        }
        
        return isUnique ? mostFrequentValue : -1;  // 유일한 경우 최빈값 반환, 아니면 -1 반환
    }
}
