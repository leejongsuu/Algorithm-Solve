class Solution {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        
        int luy = n, lux = m;
        int rdy = 0, rdx = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    if(i < luy) luy = i;
                    if(j < lux) lux = j;
                    if(i + 1 > rdy) rdy = i + 1;
                    if(j + 1 > rdx) rdx = j + 1;
                }
            }
        }
        
        return new int[]{luy, lux, rdy, rdx};
    }
}