import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        s = s.substring(1, s.length());
        StringTokenizer st = new StringTokenizer(s, "{}");
        
        List<String> tupleList = new ArrayList<>();
        
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            if(token.equals(",")) continue;
            tupleList.add(token);
        }
        
        Collections.sort(tupleList, (o1, o2) -> o1.length() - o2.length());
        
        List<Integer> resultList = new ArrayList<>();
        for(String tuple : tupleList) {
            String[] parts = tuple.split(",");
            for(String part : parts) {
                int num = Integer.parseInt(part);
                if(!resultList.contains(num)) {
                    resultList.add(num);    
                }
            }
        }
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}