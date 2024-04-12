import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] answer;
        
        List<Queue<Integer>> Qlist = new ArrayList<>();
        for(int i=0; i<3; i++) {
            Qlist.add(new LinkedList<>());
        }
        
        Qlist.get(0).addAll(Arrays.asList(1,2,3,4,5));
        Qlist.get(1).addAll(Arrays.asList(2,1,2,3,2,4,2,5));
        Qlist.get(2).addAll(Arrays.asList(3,3,1,1,2,2,4,4,5,5));
        
        int[] person = new int[3];
        
        for(int ans : answers) {
            for(int i=0; i<3; i++) {
                int num = Qlist.get(i).poll();
                if(ans == num) person[i]++;
                Qlist.get(i).offer(num);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        int max = person[0];
        list.add(1);
        
        for(int i=1; i<3; i++) {
            
            if(max==person[i]) {
                list.add(i+1);
            } else if(max < person[i]) {
                max = person[i];
                list.clear();
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}