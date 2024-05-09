import java.util.HashMap;

class Solution {
    public int solution(String s) {
        
        String answer = "";
        String[] words = new String[] {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
               
        for(int lt = 0, rt = 0; rt < s.length(); rt++) {
            if(Character.isDigit(s.charAt(rt))) {
                answer += s.charAt(rt);
                lt = rt + 1;
                continue;
            }
            
            String str = s.substring(lt, rt + 1);
            if(map.containsKey(str)) {
                answer += map.get(str);
                lt = rt + 1;
            }
        }
        return Integer.parseInt(answer);
    }
}