import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> Q = new LinkedList<>(); // 각 작업의 배포일을 저장할 큐 생성
        ArrayList<Integer> list = new ArrayList<>(); // 각 배포마다 배포되는 작업의 수를 저장할 리스트 생성
        
        // 각 작업의 진도와 속도를 이용하여 각 작업이 몇 일 후에 배포될 수 있는지를 계산하고 큐에 저장
        for(int i=0; i<speeds.length; i++) {
            double remain = 100 - progresses[i]; // 남은 진도 계산
            double fNeedDay = remain / speeds[i]; // 필요한 일 수 계산 (실수 형태)
            
            int date = (int) Math.ceil(fNeedDay); // 필요한 일 수를 올림하여 정수로 변환하여 배포일 계산
            
            // 이전 작업의 배포일보다 현재 작업의 배포일이 크면
            // 이전 작업까지의 작업 수를 리스트에 추가하고, 큐를 비움
            if(!Q.isEmpty() && Q.peek() < date) {
                list.add(Q.size());
                Q.clear();
            }
            
            // 현재 작업의 배포일을 큐에 추가
            Q.offer(date);
        }
        list.add(Q.size()); // 마지막 작업까지의 작업 수를 리스트에 추가
        
        return list.stream().mapToInt(Integer::intValue).toArray(); // 결과 반환
    }
}
