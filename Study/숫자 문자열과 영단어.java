import java.util.HashMap;

class Solution {
    public int solution(String s) {
        
        String[] words = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", };
        
        HashMap<String, Integer> digitMap = new HashMap<>();
        for(int i = 0; i < 10; i++) {
            digitMap.put(words[i], i);
        }
        
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        for(int lt = 0, rt = 1; rt <= len; rt++) {
            String key = s.substring(lt, rt);
            
            if(Character.isDigit(key.charAt(0))) {
                sb.append(key);
                lt = rt;
            } else if(digitMap.containsKey(key)) {
                sb.append(digitMap.get(key));
                lt = rt;
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}
