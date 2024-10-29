import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int result = 0;
        
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            indexMap.put(want[i], i);
        }
        
        int len = number.length;
        int[] arr = new int[len];
        
        for(int lt = 0, rt = 0; rt < discount.length; rt++) {
            if(rt - lt > 9) {
                if(indexMap.containsKey(discount[lt])) {
                    arr[indexMap.get(discount[lt])]--;
                }
                lt++;
            }
            if(indexMap.containsKey(discount[rt])) {
                arr[indexMap.get(discount[rt])]++;
            }
            
            if(Arrays.equals(arr, number)) {
                result++;
            }
        }
        
        return result;
    }
}