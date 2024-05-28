import java.util.HashSet;
import java.util.regex.Pattern;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("aya");
        hashSet.add("ye");
        hashSet.add("woo");
        hashSet.add("ma");
        
        Pattern pattern = Pattern.compile("^(aya|ye|woo|ma)+$");
        for(String ba : babbling) {
            if(pattern.matcher(ba).matches()) {
                boolean flag = true;
                for(String s : hashSet) {
                    if(ba.contains(s+s)) {
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