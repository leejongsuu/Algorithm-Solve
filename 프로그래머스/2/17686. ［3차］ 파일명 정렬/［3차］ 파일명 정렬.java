import java.util.*;

class Solution {
    
    class FileName implements Comparable<FileName> {
        String origin;
        String head;
        int number;
        
        public FileName(String origin, String head, int number) {
            this.origin = origin;
            this.head = head;
            this.number = number;
        }
        
        @Override
        public int compareTo(FileName o) {
            String tUpper = this.head.toUpperCase();
            String oUpper = o.head.toUpperCase();
            
            int comp = tUpper.compareTo(oUpper);
            if(comp == 0) {
                return this.number - o.number;
            }
            return comp;
        }
    }
    
    public String[] solution(String[] files) {
        
        List<FileName> list = new ArrayList<>();
        for(String file : files) {
            int i = 0;
            int len = file.length();
            while(i < len && !Character.isDigit(file.charAt(i))) {
                i++;
            }
            
            String head = file.substring(0, i);
            int j = i;
            while(i < len && Character.isDigit(file.charAt(i))) {
                i++;
            }
            
            int number = Integer.parseInt(file.substring(j, i));
            
            list.add(new FileName(file, head, number));
        }
        
        Collections.sort(list);
        
        int size = list.size();
        String[] result = new String[size];
        for(int i = 0; i < size; i++) {
            result[i] = list.get(i).origin;
        }
        
        return result;
    }
}