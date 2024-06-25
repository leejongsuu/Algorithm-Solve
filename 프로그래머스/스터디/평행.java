import java.util.ArrayList;

class Solution {
    public int solution(int[][] dots) {
        
        boolean[] flag = new boolean[4];
        flag[0] = true;
        
        for(int i = 1; i < dots.length; i++) {
            flag[i] = true;
            ArrayList<int[]> first = new ArrayList<>();
            ArrayList<int[]> second = new ArrayList<>();
            for(int j =0; j < dots.length; j++) {
                if(flag[j]) first.add(dots[j]);
                else second.add(dots[j]);
            }
            if(cal(first, second)) return 1; 
            flag[i] = false;
        }
        
        return 0;
    }
    
    private boolean cal(ArrayList<int[]> first, ArrayList<int[]> second) {
        
        int[] a = first.get(0);
        int[] b = first.get(1);
        double inc1 = 
            (double) Math.abs(a[1] - b[1]) / Math.abs(a[0] - b[0]);
        
        
        int[] c = second.get(0);
        int[] d = second.get(1);
        double inc2 = 
            (double) Math.abs(c[1] - d[1]) / Math.abs(c[0] - d[0]);
        
        return inc1 == inc2;
    }
}
