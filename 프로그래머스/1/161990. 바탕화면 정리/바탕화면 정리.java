class Solution {
    
    public int[] solution(String[] wallpaper) {
        
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        
        int lux, luy, rdx, rdy;
        lux = luy = rdx = rdy = 0;
        
        int[] start = init(n, m, wallpaper);
        luy = start[0];
        lux = start[1];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    if(j < lux) {
                        lux = j;
                    }
                    if(i + 1 > rdy) {
                        rdy = i + 1;
                    }
                    if(j + 1 > rdx) {
                        rdx = j + 1;
                    }
                }
            }
        }
        
        return new int[]{luy, lux, rdy, rdx};
    }
    
    private int[] init(int n, int m, String[] wallpaper) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    return new int[]{i, j};
                }
            }
        }
        
        return new int[]{-1, -1};
    }
}