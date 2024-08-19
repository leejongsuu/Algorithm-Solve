import java.util.HashMap;

class Solution {
    public int solution(int[] array) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : array) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int max = 0;
        int max_cnt = 0;
        boolean flag = true;
        
        for(Integer key : map.keySet()) {
            int cnt = map.get(key);
            if(cnt > max_cnt) {
                flag = true;
                max_cnt = cnt;
                max = key;
            } else if(cnt == max_cnt) {
                flag = false;
            }
        }
        
        return flag ? max : -1;
    }
}
