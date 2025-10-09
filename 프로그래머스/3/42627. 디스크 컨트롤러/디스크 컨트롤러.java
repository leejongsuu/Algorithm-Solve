import java.util.*;

class Solution {
    
    class Work implements Comparable<Work> {
        int index;
        int requestTime;
        int workTime;
        
        Work(int index, int requestTime, int workTime) {
            this.index = index;
            this.requestTime = requestTime;
            this.workTime = workTime;
        }
        
        @Override
        public int compareTo(Work o) {
            if(this.workTime == o.workTime) {
                if(this.requestTime == o.requestTime) {
                    return this.index - o.index;
                }
                return this.requestTime - o.requestTime;
            }
            
            return this.workTime - o.workTime;
        }
    }
    
    public int solution(int[][] jobs) {
        
        int len = jobs.length;
        Work[] works = new Work[len];
        
        for(int i = 0; i < len; i++) {
            works[i] = new Work(i, jobs[i][0], jobs[i][1]);
        }
        
        Arrays.sort(works, (a, b) -> a.requestTime - b.requestTime);
        
        PriorityQueue<Work> pq = new PriorityQueue<>();
        
        int totalResponse = 0;
        int currentTime = 0;
        int index = 0;
        int sum = 0;
        
        while(totalResponse < len) {
            while(index < len && works[index].requestTime <= currentTime) {
                pq.offer(works[index++]);
            }
            
            if(pq.isEmpty()) {
                currentTime = works[index].requestTime;
                continue;
            }
            
            Work current = pq.poll();
            
            currentTime += current.workTime;
            sum += currentTime - current.requestTime;
            totalResponse++;
        }
        
        return sum / len;
    }
}