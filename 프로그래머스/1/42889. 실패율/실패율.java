import java.util.PriorityQueue;

class Solution {
    
    class Stage implements Comparable<Stage> {
        int number;
        double failureRate;
        
        public Stage(int number, double failureRate) {
            this.number = number;
            this.failureRate = failureRate;
        }
        
        @Override
        public int compareTo(Stage o) {
            // 실패율이 높은 순으로 정렬, 같으면 번호가 낮은 순으로 정렬
            int flag = Double.compare(o.failureRate, this.failureRate);
            if(flag == 0) {
                return this.number - o.number;
            } else {
                return flag;
            }
        }
    }
    
    public int[] solution(int N, int[] stages) {
        
        PriorityQueue<Stage> priorityQueue = new PriorityQueue<>();
        
        // N + 1 크기의 배열을 사용
        int[] user = new int[N + 2];
        for(int stage : stages) {
            user[stage]++;
        }
        
        int totalPerson = stages.length;
        for(int i = 1; i <= N; i++) {
            // 도달한 사용자가 없으면 실패율은 0
            double rate = totalPerson > 0 ? (double) user[i] / totalPerson : 0;
            priorityQueue.offer(new Stage(i, rate));  // 스테이지 번호 i, 실패율 rate
            totalPerson -= user[i];
        }
        
        int[] result = new int[N];
        for(int i = 0; i < N; i++) {
            result[i] = priorityQueue.poll().number;  // 스테이지 번호 저장
        }
        
        return result;
    }
}
