import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
       
        Set<String> numberSet = new HashSet<>();
        for(String phoneNumber : phoneBook) {
            numberSet.add(phoneNumber);
        }
        
        for(String phoneNumber : phoneBook) {
            int len = phoneNumber.length();
            for(int i = 1; i < len; i++) {
                String s = phoneNumber.substring(0, i);
                if(numberSet.contains(s)) {
                    return false;
                }
            }
        }
        return true;
    }
}