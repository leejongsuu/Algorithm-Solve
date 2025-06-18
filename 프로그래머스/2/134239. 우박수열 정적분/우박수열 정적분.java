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
        
        List<Point> points = new ArrayList<>();
        
        int n = 0;
        while(k > 1) {
            points.add(new Point(n, k));
            k = (k % 2 == 0 ? k / 2 : k * 3 + 1);
            n++;
        }
        points.add(new Point(n, 1));
        
        double[] dis = new double[n];
        for(int i = 0; i < n; i++) {
            Point a = points.get(i);
            Point b = points.get(i + 1);
            dis[i] = (a.y + b.y) / 2.0;
        }
        
        int size = ranges.length;
        double[] result = new double[size];
        
        for(int i = 0; i < size; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1];
            if(start > end) {
                result[i] = -1.0;
            } else {
                double sum = 0;
                for(int j = start; j < end; j++) {
                    sum += dis[j];
                }
                result[i] = sum;
            }
        }
        
        return result;
    }
}