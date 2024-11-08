import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        List<Integer> result = new ArrayList<>();
        
        int index = 27; // 사전의 색인 번호 27부터 시작
        Map<String, Integer> map = new HashMap<>();
        
        // A부터 Z까지 사전에 초기화
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        int len = msg.length();
        String before = "";
        for (int i = 0; i < len;) {
            int j = i + 1;
            for (; j <= len; j++) {
                String temp = msg.substring(i, j);
                
                // 사전에 없는 경우
                if (!map.containsKey(temp)) {
                    result.add(map.get(before)); // 직전 일치하는 문자열의 색인 번호 저장
                    map.put(temp, index++); // 새로운 문자열을 사전에 추가
                    break;
                }
                
                before = temp; // 현재 일치하는 문자열 저장
            }
            i = j - 1; // 현재 위치를 다음 위치로 업데이트
        }
        
        // 마지막 남은 문자열의 색인 번호 추가
        result.add(map.get(before));
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
