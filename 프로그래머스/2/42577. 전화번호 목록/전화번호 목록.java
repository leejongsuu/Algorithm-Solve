import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 전화번호를 저장할 HashSet 생성
        HashSet<String> set = new HashSet<>();
        
        // 전화번호를 HashSet에 저장
        for (String phoneNumber : phone_book) {
            set.add(phoneNumber);
        }
        
        // 각 전화번호에 대해 접두사가 있는지 확인
        for (String phoneNumber : phone_book) {
            // 전화번호의 가능한 모든 접두사를 확인
            for (int i = 1; i < phoneNumber.length(); i++) {
                String prefix = phoneNumber.substring(0, i);
                // HashSet에 접두사가 있다면 false 반환
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }
        
        // 모든 접두사를 확인한 후에도 중복되는 접두사가 없다면 true 반환
        return true;
    }
}