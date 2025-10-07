import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        List<Integer> list = new ArrayList<>();
        
        for(String operation : operations) {
            String[] parts = operation.split(" ");
            
            String command = parts[0];
            int value = Integer.parseInt(parts[1]);
            
            if(command.equals("I")) {
                int index = binarySearch(value, list);
                list.add(index, value);
            } else {
                if(list.isEmpty()) {
                    continue;
                }
                
                if(value == -1) {
                    list.remove(0);
                } else {
                    list.remove(list.size() - 1);
                }
            }
        }
        
        return list.isEmpty() ? new int[]{0, 0} : new int[]{list.get(list.size() - 1), list.get(0)};
    }
    
    public int binarySearch(int target, List<Integer> list) {
        int lt = 0, rt = list.size();
        
        while(lt < rt) {
            int mid = lt + (rt - lt) / 2;
            
            if(list.get(mid) < target) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        
        return lt;
    }
}