class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        boolean[] lottoArr = new boolean[46];
        for(int win_num : win_nums) {
            lottoArr[win_num] = true;
        }
        
        int corrcet = 0;
        int zero_count = 0;
        for(int lotto : lottos) {
            if(lottoArr[lotto]) {
                corrcet++;
            } else if(lotto == 0) {
                zero_count++;
            }
        }
        
        int high = 7 - (corrcet + zero_count);    
        int low = 7 - corrcet;
        if(high > 6) high = 6;
        if(low > 6) low = 6;
        
        return new int[]{high, low};
    }
}