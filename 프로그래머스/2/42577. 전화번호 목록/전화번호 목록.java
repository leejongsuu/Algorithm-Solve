import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> phoneSet = new HashSet<>();
        for(String phone : phone_book) {
            phoneSet.add(phone);
        }
        
        for(String phone : phone_book) {
            int len = phone.length();
            for(int i = 1; i < len; i++) {
                if(phoneSet.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}