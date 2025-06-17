import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Comparator<int[]> comp = new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dif = o1[col - 1] - o2[col - 1];
                if(dif == 0) return o2[0] - o1[0];
                return dif;                
            }
        };
        
        Arrays.sort(data, comp);
        
        int answer = 0;
        for(int row = row_begin; row <= row_end; row++) {
            int sum = 0;
            for(int num : data[row - 1]) {
                sum += num % row;
            }
            answer ^= sum;
        }
        
        return answer;
    }
}