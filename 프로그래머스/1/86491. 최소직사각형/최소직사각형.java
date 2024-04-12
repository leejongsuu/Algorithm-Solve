import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];
            
            // 현재 명함의 가로, 세로 길이 중에서 최댓값 갱신
            maxWidth = Math.max(maxWidth, Math.max(width, height));
            maxHeight = Math.max(maxHeight, Math.min(width, height));
        }
        
        // 최종 지갑의 크기 반환
        return maxWidth * maxHeight;
    }
}
