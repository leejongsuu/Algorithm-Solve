import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        int win = 0;
        
        int n = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idxA = 0;
        int idxB = 0;
        
        while(idxB < n) {
            while(idxB < n && B[idxB] <= A[idxA]) {
                idxB++;
            }
            
            if(idxB >= n) {
                return win;
            }
            
            win++;
            idxA++;
            idxB++;
        }
        
        return win;
    }
}