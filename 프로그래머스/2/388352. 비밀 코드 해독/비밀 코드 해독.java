import java.util.*;
class Solution {
    
    List<int[]> combiList = new ArrayList<>();
    
    public int solution(int n, int[][] q, int[] ans) {
        int result = 0;
        int size = q.length;

        makeCombination(0, 1, new int[5], n);
        
        for(int[] combi : combiList) {
            boolean flag = true;
            for(int i = 0; i < size; i++) {
                int count = compareArr(combi, q[i]);
                if(ans[i] != count) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                result++;
            }
        }
        return result;
    }
    
    void makeCombination(int depth, int start, int[] combi, int n) {
        if(depth == 5) {
            combiList.add(combi.clone());
            return;
        }
        
        for(int i = start; i <= n; i++) {
            combi[depth] = i;
            makeCombination(depth + 1, i + 1, combi, n);
        }
    }
    
    int compareArr(int[] a, int[] b) {
        int ans = 0;
        int lt = 0, rt = 0;
        while(lt < 5 && rt < 5) {
            if(a[lt] == b[rt]) {
                ans++;
                lt++;
                rt++;
            } else if(a[lt] < b[rt]) {
                lt++;
            } else {
                rt++;
            }
        }
        return ans;
    }
}