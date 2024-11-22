import java.util.*;

class Solution {
    
    public String[] solution(String[] record) {
        
        final String ENTER = "%s님이 들어왔습니다.";
        final String LEAVE = "%s님이 나갔습니다.";
        
        Map<String, String> userMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        
        for(String str : record) {
            String[] strArr = str.split(" ");
            String command = strArr[0];
            
            if(!command.equals("Leave")) {
                userMap.put(strArr[1], strArr[2]);
            }
            
            if(!command.equals("Change")) {
                queue.offer(str);
            }
        }
        
        int size = queue.size();
        String[] result = new String[size];
        
        for(int i = 0; !queue.isEmpty(); i++) {
            String str = queue.poll();
            String[] strArr = str.split(" ");
            
            String command = strArr[0];
            String uid = strArr[1];
            if(command.equals("Enter")) {
                result[i] = String.format(ENTER, userMap.get(uid));
            } else {
                result[i] = String.format(LEAVE, userMap.get(uid));
            }
        }
        
        return result;
    }
}