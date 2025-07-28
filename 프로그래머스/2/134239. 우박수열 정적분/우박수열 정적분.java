import java.util.*;

class Solution {
    
    class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public double[] solution(int k, int[][] ranges) {
        List<Point> pointList = new ArrayList<>();
        
        for(int x = 0; k >= 1; x++) {
            pointList.add(new Point(x, k));
            if(k == 1) {
                break;
            }
            k = (k % 2 == 0 ? k / 2 : k * 3 + 1);
        }
        
        int n = pointList.size() - 1;
        double[] dis = new double[n];
        for(int i = 0; i < n; i++) {
            Point a = pointList.get(i);
            Point b = pointList.get(i + 1);
            
            dis[i] = (a.y + b.y) / 2.0;
        }
        
        int len = ranges.length;
        double[] result = new double[len];
        for(int i = 0; i < len; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1];
            if(start > end) {
                result[i] = -1;
                continue;
            }
            
            double sum = 0;
            for(int j = start; j < end; j++) {
                sum += dis[j];
            }
            
            result[i] = sum;
        }
        
        return result;
    }
}