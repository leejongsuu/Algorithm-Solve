import java.util.*;

class Solution {
    
    class Plan {
        String name;
        int start;     // 시작 시각 (분 단위)
        int playTime;  // 남은 수행 시간(분)

        public Plan(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        int n = plans.length;
        List<Plan> list = new ArrayList<>(n);

        for (String[] p : plans) {
            String name = p[0];
            int start = toMinutes(p[1]);
            int play = Integer.parseInt(p[2]);
            list.add(new Plan(name, start, play));
        }

        list.sort(Comparator.comparingInt(o -> o.start));

        List<String> answer = new ArrayList<>();
        Stack<Plan> stack = new Stack<>();

        for (int i = 0; i < n - 1; i++) {
            Plan cur = list.get(i);
            int nextStart = list.get(i + 1).start;

            if (cur.start + cur.playTime <= nextStart) {
                answer.add(cur.name);
                int finishedTime = cur.start + cur.playTime;

                // 남은 시간을 이용해 스택에 쌓인 과제 이어서 수행
                int gap = nextStart - finishedTime;
                while (gap > 0 && !stack.isEmpty()) {
                    Plan prev = stack.pop();
                    if (prev.playTime <= gap) {
                        // 이 과제도 끝낼 수 있으면
                        gap -= prev.playTime;
                        answer.add(prev.name);
                    } else {
                        // 여유 시간만큼만 수행하고 남은 시간 다시 스택에 쌓기
                        prev.playTime -= gap;
                        gap = 0;
                        stack.push(prev);
                    }
                }
            } else {
                int elapsed = nextStart - cur.start;
                cur.playTime -= elapsed;
                stack.push(cur);
            }
        }

        // 마지막 과제는 예약된 시각에 무조건 시작해서 끝낼 수밖에 없음
        Plan last = list.get(n - 1);
        answer.add(last.name);

        // 모든 예정 과제를 다 돌고 나면, 스택에 남은 과제들을 마저 끝낸다
        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }

        // 결과를 배열로 바꿔 반환
        return answer.toArray(new String[0]);
    }
    
    private int toMinutes(String time) {
        String[] sp = time.split(":");
        return Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
    }
}