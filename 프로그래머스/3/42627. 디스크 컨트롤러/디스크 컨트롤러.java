import java.util.*;

class Solution {
    
    public int solution(int[][] jobs) {
        
        int len = jobs.length;
        int totalResponseTime = 0;
        int processedJobs = 0; 
        int jobIndex = 0;      
        int currentTime = 0;   

        Work[] works = new Work[len];
        for (int i = 0; i < len; i++) {
            works[i] = new Work(i, jobs[i][0], jobs[i][1]);
        }

        Arrays.sort(works, (a, b) -> a.startTime - b.startTime);

        PriorityQueue<Work> pq = new PriorityQueue<>();

        while (processedJobs < len) {
            while (jobIndex < len && works[jobIndex].startTime <= currentTime) {
                pq.offer(works[jobIndex++]);
            }

            if (pq.isEmpty()) {
                currentTime = works[jobIndex].startTime;
            } 
            else {
                Work current = pq.poll();

                currentTime += current.workTime;
                totalResponseTime += currentTime - current.startTime;
                processedJobs++;
            }
        }

        return totalResponseTime / len;
    }
    
    class Work implements Comparable<Work> {
        int index;
        int startTime;
        int workTime;
        
        Work(int index, int startTime, int workTime) {
            this.index = index;
            this.startTime = startTime;
            this.workTime = workTime;
        }
        
        @Override
        public int compareTo(Work o) {
            if(this.workTime == o.workTime) {
                if(this.startTime == o.startTime) {
                    return this.index - o.index;
                }
                return this.startTime - o.startTime;
            }
            return this.workTime - o.workTime;
        }
    }
}