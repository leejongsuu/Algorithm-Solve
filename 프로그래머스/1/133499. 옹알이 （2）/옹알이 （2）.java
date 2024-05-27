import java.util.HashSet;
import java.util.regex.Pattern;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        HashSet<String> set = new HashSet<>();
        set.add("aya");
        set.add("ye");
        set.add("woo");
        set.add("ma");
        
        Pattern pattern = Pattern.compile("^(aya|ye|woo|ma)+$");
        
        for(String str : babbling) {
            
            if(pattern.matcher(str).matches()) {
                boolean flag = true;
                for(String s : set) {
                    if(str.contains(s + s)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        
        return answer;
    }
}