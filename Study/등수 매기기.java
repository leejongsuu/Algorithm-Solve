import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(int[][] score) {
        
        int len = score.length;
        
        double[] avgArr = new double[len];
        for(int i = 0; i < len; i++) {
            avgArr[i] = (double) (score[i][0] + score[i][1]) / 2;
        }
        
        Arrays.sort(avgArr);
        
        int rank = 1;
        HashMap<Double, Integer> rankMap = new HashMap<>();
        
        for(int i = len - 1; i >=0; i--, rank++) {
            if(rankMap.containsKey(avgArr[i])) {
                continue;
            }
            rankMap.put(avgArr[i], rank);
        }
        
        int[] result = new int[len];
        for(int i = 0; i < len; i++) {
            double avg = (double) (score[i][0] + score[i][1]) / 2;
            result[i] = rankMap.get(avg);
        }
        
        
        return result;
    }
}
