import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Comparator<int[]> comp = new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[col - 1] != o2[col -1]) {
                    return o1[col - 1] - o2[col -1];
                }
                return o2[0] - o1[0];
            }
        };
        
        Arrays.sort(data, comp);
        
        int result = 0;
        
        for(int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for(int d : data[i - 1]) {
                sum += d % i;
            }
            result ^= sum;
        }
        
        return result;
    }
}