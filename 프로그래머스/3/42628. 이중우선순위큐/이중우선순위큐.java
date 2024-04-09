import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        for(String operation : operations) {
            String[] strArr = operation.split(" ");
            
            if(strArr[0].equals("I")) {
                int key = Integer.parseInt(strArr[1]);
                treeMap.put(key, treeMap.getOrDefault(key, 0)+1);
            } else if(!treeMap.isEmpty()) {
                if(strArr[1].equals("-1")) {
                    int key = treeMap.firstKey();
                    int value = treeMap.get(key);
                    if(value == 1) {
                        treeMap.remove(key);
                    } else {
                        treeMap.put(key, value - 1);
                    }
                } else {
                    int key = treeMap.lastKey();
                    int value = treeMap.get(key);
                    if(value == 1) {
                        treeMap.remove(key);
                    } else {
                        treeMap.put(key, value - 1);
                    }
                }
            }
        }
        
        if(treeMap.isEmpty()) {
            answer[0] = answer[1] = 0;
        } else {
            answer[0] = treeMap.lastKey();
            answer[1] = treeMap.firstKey();
        }
        
        return answer;
    }
}
