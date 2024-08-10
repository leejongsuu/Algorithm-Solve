import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        
        int cameraCount = 0;
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < routes.length; i++) {
            if(routes[i][0] > max) {
                cameraCount++;
                max = routes[i][1];
            }
        }
        
        return cameraCount;
    }
}
