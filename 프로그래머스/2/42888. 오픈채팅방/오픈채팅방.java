import java.util.*;

class Solution {
    class User {
        String id;
        boolean isEnter;
        
        public User(String id, boolean isEnter) {
            this.id = id;
            this.isEnter = isEnter;
        }
    }
    public String[] solution(String[] record) {
        Queue<User> queue = new LinkedList<>();
        Map<String, String> userMap = new HashMap<>();
        
        for(String info : record) {
            String[] parts = info.split(" ");
            String command = parts[0];
            String id = parts[1];
            
            if(command.equals("Leave")) {
                queue.offer(new User(id, false));
                continue;
            }
            
            String name = parts[2];
            userMap.put(id, name);
            if(command.equals("Enter")) {
                queue.offer(new User(id, true));
            }
        }
            
        String[] result = new String[queue.size()];
        for(int i = 0; !queue.isEmpty(); i++) {
            User user = queue.poll();
            String end = user.isEnter ? "들어왔습니다." : "나갔습니다.";
            result[i] = userMap.get(user.id) + "님이 " + end;
        }
            
        return result;
    }
}