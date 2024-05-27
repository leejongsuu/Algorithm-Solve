import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] arr = new int[N+2];
        for(int i : stages) arr[i]++;
        
        ArrayList<Stage> list = new ArrayList<>();
        int denominator = stages.length;
        for(int i = 1; i <=N; i++) {
            denominator -= arr[i-1];
            if(denominator <= 0) {
                list.add(new Stage(i, 0));
                continue;
            }
            double cal = (double) arr[i] / denominator;
            list.add(new Stage(i, cal));
        }
        
        Collections.sort(list);
        return list.stream().mapToInt(Stage::getNumber).toArray();
    }
    
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
            if(o.failureRate == this.failureRate) return this.number - o.number;
            else return Double.compare(o.failureRate, this.failureRate);
        }
    }
}