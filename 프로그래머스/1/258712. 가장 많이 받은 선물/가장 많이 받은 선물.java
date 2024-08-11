import java.util.HashMap;
import java.util.ArrayList;

class Person {
    int giveCount;
    int receiveCount;
    HashMap<String, Integer> giveMap = new HashMap<>();
    
    public void addGiveCount(String name) {
        giveCount++;
        giveMap.put(name, giveMap.getOrDefault(name, 0) + 1);
    }
    
    public void addReceiveCount() {
        receiveCount++;
    }
}

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        HashMap<String, Person> friendMap = new HashMap<>();
        for(String friend : friends) {
            friendMap.put(friend, new Person());
        }
        
        for(String gift : gifts) {
            String[] splited = gift.split(" ");
            String give = splited[0];
            String receive = splited[1];
            friendMap.get(give).addGiveCount(receive);
            friendMap.get(receive).addReceiveCount();
        }
        
        int result = 0;
        for(int i = 0; i < friends.length; i++) {
            int count = 0;
            Person person = friendMap.get(friends[i]);
            
            for(int j = 0; j < friends.length; j++) {
                if(i == j) continue;
                
                Person person2 = friendMap.get(friends[j]);
                Integer num = person.giveMap.get(friends[j]);
                Integer num2 = person2.giveMap.get(friends[i]);
                num = (num == null ? 0 : num);
                num2 = (num2 == null ? 0 : num2);
                
                if(num > num2) {
                    count++;
                } else if(num == num2) {
                    int index = person.giveCount - person.receiveCount;
                    int index2 = person2.giveCount - person2.receiveCount;
                    
                    if(index > index2) {
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }
        
        return result;
    }
}