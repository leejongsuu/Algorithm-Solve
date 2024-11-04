import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        Set<Integer> tuple = new HashSet<>();
        
        String[] strArr = s.replaceAll("[{}]", " ").trim().split(" , ");
        Arrays.sort(strArr, (o1, o2) -> o1.length() - o2.length());
        
        int size = strArr.length;
        int[] result = new int[size];
        
        for(int i = 0; i < size; i++) {
            String[] elements = strArr[i].split(",");
            for(int j = 0; j < elements.length; j++) {
                int element = Integer.parseInt(elements[j]);
                if(tuple.add(element)) {
                    result[i] = element;
                    break;
                }
            }
        }
        
        return result;
    }
}