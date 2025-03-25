import java.util.*;

class Solution {
    
    class Stage implements Comparable<Stage> {
        int num;
        double failureRate;
        
        public Stage(int num, double failureRate) {
            this.num = num;
            this.failureRate = failureRate;
        }
        
        @Override
        public int compareTo(Stage o) {
            int comp = Double.compare(o.failureRate, this.failureRate);
            if(comp == 0) return this.num - o.num;
            else return comp;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        
        List<Stage> stageList = new ArrayList<>();
        
        Arrays.sort(stages);
        
        int len = stages.length;
        int challenger = len;
        
        for(int i = 1, j = 0; i <= N; i++) {
            int notClear = 0;
            while(j < len  && i == stages[j]) {
                notClear++;
                j++;
            }
            
            if(challenger <= 0) {
                stageList.add(new Stage(i, 0));
                continue;
            }
            
            double failureRate = (double) notClear / challenger;
            stageList.add(new Stage(i, failureRate));
            challenger -= notClear;
        }
        
        Collections.sort(stageList);
        
        int[] result = new int[N];
        for(int i = 0; i < N; i++) {
            result[i] = stageList.get(i).num;
        }
        
        return result;
    }
}