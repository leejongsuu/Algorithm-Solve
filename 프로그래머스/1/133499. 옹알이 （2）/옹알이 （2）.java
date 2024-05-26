import java.util.HashSet;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        HashSet<String> set = new HashSet<>();
        set.add("aya");
        set.add("ye");
        set.add("woo");
        set.add("ma");
        
        for(String str : babbling) {
            StringBuilder sb = new StringBuilder();
            int len = str.length();
            int sum = 0;
            String before ="";
            
            for(int i = 0; i < len; i++) {
                sb.append(str.charAt(i));
                if(sb.length() > 3) break;
                
                if(set.contains(sb.toString())) {
                    if(sb.toString().equals(before)) {
                        break;
                    }
                    else {
                        before = sb.toString();
                        sum += before.length();
                        sb.setLength(0);
                    }
                }
            }
            if(len == sum) {
                answer++;
            }
        }
        
        return answer;
    }
}