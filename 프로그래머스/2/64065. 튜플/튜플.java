import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] strArr = s.replaceAll("[{}]", " ").trim().split(" , ");
        
        Set<Integer> set = new HashSet<>();
        int size = strArr.length;
        int[] result = new int[size];
        
        Arrays.sort(strArr, (o1, o2) -> o1.length() - o2.length());
        
        for(int i = 0; i < size; i++) {
            String[] elements = strArr[i].split(",");
            for(String element : elements) {
                int iNum = Integer.parseInt(element);
                if(set.add(iNum)) {
                    result[i] = iNum;
                    break;
                }
            }
        }
            
        return result;
    }
}