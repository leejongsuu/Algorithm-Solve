import java.util.*;

class Solution {
    
    class Stage implements Comparable<Stage> {
        int index;
        double failure;
        
        Stage(int index, double failure) {
            this.index = index;
            this.failure = failure;
        }
        
        @Override
        public int compareTo(Stage o) {
            return Double.compare(o.failure, this.failure);
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] result = new int[N];
        
        Arrays.sort(stages);
        
        Stage[] stageArr = new Stage[N];
        
        int people = stages.length;
        int index = 0;
        
        // 1 2 2 3 3 4 6
        for(int i = 1; i <= N; i++) {
            int cnt = 0;
            while(index < stages.length && stages[index] <= i) {
                index++;                
                cnt++;
            }
            
            double fail = 0;
            if(people > 0) {
                fail = (double) cnt / people;
            }
            stageArr[i - 1] = new Stage(i, fail);
            people -= cnt;
        }
        
        Arrays.sort(stageArr);
        
        for(int i = 0; i < N; i++) {
            result[i] = stageArr[i].index;
        }
        
        return result;
    }
}