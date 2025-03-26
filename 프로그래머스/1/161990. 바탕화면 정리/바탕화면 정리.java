class Solution {
    public int[] solution(String[] wallpaper) {
        int lur = Integer.MAX_VALUE;
        int luc = Integer.MAX_VALUE;
        int rdr = Integer.MIN_VALUE;
        int rdc = Integer.MIN_VALUE;
        
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    lur = Math.min(lur, i);
                    luc = Math.min(luc, j);
                    rdr = Math.max(rdr, i + 1);
                    rdc = Math.max(rdc, j + 1);
                }
            }
        }
        
        return new int[]{lur, luc, rdr, rdc};
    }
}