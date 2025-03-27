import java.util. *;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            double day = 100 - progresses[i];
            queue.offer((int) Math.ceil(day / speeds[i]));
        }
        
        
        List<Integer> resultList = new ArrayList<>();
        int count = 1, before = queue.poll();
        for(int work : queue) {
            if(work > before) {
                resultList.add(count);
                count = 0;
                before = work;
            }
            count++;
        }
        resultList.add(count);
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}