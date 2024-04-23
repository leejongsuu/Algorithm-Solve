import java.util.TreeSet;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i : arr) {
            if(i % divisor == 0) treeSet.add(i);
        }
        
        int size = treeSet.size();
        if(size == 0) {
            return new int[]{-1};
        } else {
            int[] answer = new int[size];
            int i = 0;
            for(int n : treeSet) {
                answer[i++] = n;
            }
            return answer;
        }
    }
}