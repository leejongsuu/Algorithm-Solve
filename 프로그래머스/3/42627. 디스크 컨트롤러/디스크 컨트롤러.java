import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 작업이 요청되는 시점 기준으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        // 작업의 소요시간 기준으로 오름차순 정렬
        PriorityQueue<int[]> PQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int jobs_index = 0; // 작업 배열 인덱스
        int finish_job = 0; // 처리 완료된 작업 개수
        int end_time = 0; // 작업 처리 완료 시간
        
        while(true) {
            
            if(finish_job == jobs.length) break;
            
            while(jobs_index < jobs.length && jobs[jobs_index][0] <= end_time) {
                PQ.offer(jobs[jobs_index++]);
            }
            
            if(!PQ.isEmpty()) {
                int[] job = PQ.poll();
                answer += end_time - job[0] + job[1];
                end_time += job[1];
                finish_job++;
            } else {
                end_time = jobs[jobs_index][0];
            }
        }
        
        return answer / jobs.length;
    }
}