import java.util.*;

class Solution {
    
    public int[] solution(int N, int[] stages) {
        
        int[] arr = new int[N+2];
        for(int i : stages) {
            arr[i]++;
        }
        
        int denominator = stages.length;
        ArrayList<Stage> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            denominator -= arr[i-1];
            if(denominator <= 0) {
                list.add(new Stage(i, 0));
                continue;
            }
            double result = (double) arr[i] / denominator;
            list.add(new Stage(i, result));
        }
        
        Collections.sort(list);
       
        int[] result = new int[N];
        for(int i = 0; i < N; i++) {
            result[i] = list.get(i).number;
        }
        
        return result;
    }
    
    class Stage implements Comparable<Stage> {
        int number;
        double failureRate;
        
        public Stage(int number, double failureRate) {
            this.number = number;
            this.failureRate = failureRate;
        }
        
        @Override
        public int compareTo(Stage o) {
            if(o.failureRate == this.failureRate) return this.number - o.number;
            else return Double.compare(o.failureRate, this.failureRate);
        }
    }
}