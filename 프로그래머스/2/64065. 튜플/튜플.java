import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s, "{}");
        
        int size = st.countTokens() / 2 + 1;
        String[] strArr = new String[size];
        
        for(int i = 0; st.hasMoreTokens(); i++) {
            String token  = st.nextToken();
            if(i % 2 == 1) {
                continue;
            }
            strArr[i/2] = token;
        }
        
        Arrays.sort(strArr, (o1, o2) -> o1.length() - o2.length());
        
        int[] result = new int[size];
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < size; i++) {
            String[] split = strArr[i].split(",");
            for(int j = 0; j < split.length; j++) {
                int iNum = Integer.parseInt(split[j]);
                if(!set.contains(iNum)) {
                    set.add(iNum);
                    result[i] = iNum;
                    break;
                }
            }
        }
        
        return result;
    }
}