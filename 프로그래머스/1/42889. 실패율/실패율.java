import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    class Stage implements Comparable<Stage> {
        int number;
        double failureRate;
        
        public Stage(int number, double failureRate) {
            this.number = number;
            this.failureRate = failureRate;
        }
        
        public int getNumber() {
            return this.number;
        }
        
        @Override
        public int compareTo(Stage o) {
            int flag = Double.compare(o.failureRate, this.failureRate);
            if(flag == 0) {
                return this.number - o.number;
            } else {
                return flag;
            }
        }
        
    }
    
    public int[] solution(int N, int[] stages) {
        
        Arrays.sort(stages);
        
        ArrayList<Stage> resultList = new ArrayList<>();
        
        int len = stages.length;
        int totalPerson = len;
        
        for(int i = 1, j = 0; i <= N; i++) {
            int cnt = 0;
            while(j < len && i == stages[j]) {
                cnt++;
                j++;
            }
            double rate = totalPerson == 0 ? 0 : (double) cnt / totalPerson;
            resultList.add(new Stage(i, rate));
            totalPerson -= cnt;
        }
        
        Collections.sort(resultList);
        
        return resultList.stream().mapToInt(Stage::getNumber).toArray();
    }
}