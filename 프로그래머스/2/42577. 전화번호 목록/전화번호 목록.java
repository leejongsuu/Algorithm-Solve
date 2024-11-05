import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> numberSet = new HashSet<>();
        for(String phoneNumber : phone_book) {
            numberSet.add(phoneNumber);
        }
        
        for(String phoneNumber : phone_book) {
            int len = phoneNumber.length();
            for(int i = 0; i < len; i++) {
                String s = phoneNumber.substring(0, i);
                if(numberSet.contains(s)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}