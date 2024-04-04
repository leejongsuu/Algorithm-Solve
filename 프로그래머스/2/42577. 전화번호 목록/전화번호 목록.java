import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        boolean answer = true;
        
        HashSet<String> set = new HashSet<>();
        for(String phoneNumber : phone_book) {
            set.add(phoneNumber);
        }
        
        for(String str : phone_book) {
            for(int i=1; i< str.length(); i++) {
                if(set.contains(str.substring(0,i))) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}