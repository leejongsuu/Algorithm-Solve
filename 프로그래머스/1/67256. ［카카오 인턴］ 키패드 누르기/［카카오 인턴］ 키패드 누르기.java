class Solution {
    
    class Point {
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        public void setPoint(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public String solution(int[] numbers, String hand) {
        
        Point leftThumb = new Point(3, 0);
        Point rightThumb = new Point(3, 2);
        
        StringBuilder sb = new StringBuilder();
        for(int i : numbers) {
            i -= 1;
            int y = i == -1 ? 3 : i / 3;
            int x = i == -1 ? 1 : i % 3;
            if(x == 0) {
                sb.append('L');
                leftThumb.setPoint(y, x);
            } else if(x == 2) {
                sb.append('R');
                rightThumb.setPoint(y, x);
            } else {
                int left = Math.abs(y - leftThumb.y) + Math.abs(x - leftThumb.x);
                int right = Math.abs(y - rightThumb.y) + Math.abs(x - rightThumb.x);
                if(left == right) {
                    if(hand.equals("left")) {
                        sb.append('L');
                        leftThumb.setPoint(y, x);
                    } else {
                        sb.append('R');
                        rightThumb.setPoint(y, x);
                    }
                } else {
                    if(left < right) {
                        sb.append('L');
                        leftThumb.setPoint(y, 1);
                    } else {
                        sb.append('R');
                        rightThumb.setPoint(y, 1);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}