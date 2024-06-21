class Solution {
    
    public int[] solution(String[] wallpaper) {
        
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        
        int minY = n, minX = m, maxY = 0, maxX = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    if(i < minY) minY = i;
                    if(j < minX) minX = j;
                    if (i + 1 > maxY) maxY = i + 1;
                    if (j + 1 > maxX) maxX = j + 1;
                }
            }
        }
        
        return new int[]{minY, minX, maxY, maxX};
    }
}