import java.util.HashSet;

class Solution {
    public int solution(String[] babbling) {
        
        String[] babbles = {"aya", "ye", "woo", "ma"};
        
        HashSet<String> babbleSet = new HashSet<>();
        for(String babble : babbles) {
            babbleSet.add(babble);
        }
        
        int result = 0;
        
        for(String babble : babbling) {
            String before = "";
            int length = 0;
            for(int lt =0, rt = 2; rt <= babble.length(); rt++) {
                String subStr = babble.substring(lt, rt);
                if(subStr.equals(before)) break;
                
                if(babbleSet.contains(subStr)) {
                    before = subStr;
                    length += subStr.length();
                    lt = rt;
                }
            }
            if(length == babble.length()) {
                result++;
            }
        }
        
        return result;
    }
}