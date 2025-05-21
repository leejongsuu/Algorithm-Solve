import java.util.*;

class Solution {
    
    class Sequence implements Comparable<Sequence> {
        int lt;
        int rt;
        
        public Sequence(int lt, int rt) {
            this.lt = lt;
            this.rt = rt;
        }
        
        @Override
        public int compareTo(Sequence o) {
            int cDis = this.rt - this.lt;
            int nDis = o.rt - o.lt;
            
            if(cDis == nDis) return this.lt - o.lt;
            else return cDis - nDis;
        }
    }
    
    public int[] solution(int[] sequence, int k) {
        
        List<Sequence> list = new ArrayList<>();
        
        int len = sequence.length;
        int sum = 0;
        for(int lt = 0, rt = 0; rt < len; rt++) {
            sum += sequence[rt];
            
            while(sum > k && lt < len) {
                sum -= sequence[lt++];
            }
            
            if(sum == k) {
                list.add(new Sequence(lt, rt));
            }
        }
        
        Collections.sort(list);
        
        Sequence seq = list.get(0);
        return new int[]{seq.lt, seq.rt};
    }
}