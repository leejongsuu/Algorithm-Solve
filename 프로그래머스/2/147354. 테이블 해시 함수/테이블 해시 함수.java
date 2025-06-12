import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        Comparator<int[]> comp = new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[col - 1] != o2[col - 1]) {
                    return o1[col - 1] - o2[col - 1];
                }
                
                return o2[0] - o1[0];
            }
        };
        
        Arrays.sort(data, comp);
        
        List<Integer> datas = new ArrayList<>();
        
        int len = data[0].length;
        for(int i = row_begin; i <= row_end; i++) {
            int idx = i - 1;
            int sum = 0;
            for(int j = 0; j < len; j++) {
                sum += data[idx][j] % i;
            }
            datas.add(sum);
        }
        
        int result = 0;
        for(int d : datas) {
            result ^= d;
        }
        return result;
    }
}