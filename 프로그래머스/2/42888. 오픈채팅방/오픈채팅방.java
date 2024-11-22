import java.util.*;

class Solution {
    
    public String[] solution(String[] record) {
        
        Map<String, String> userMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();
        
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
                result[i] = userMap.get(uid) +"님이 들어왔습니다.";
            } else {
                result[i] = userMap.get(uid) +"님이 나갔습니다.";
            }
        }
        
        return result;
    }
}