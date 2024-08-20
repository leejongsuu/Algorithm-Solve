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
        // 엄지손가락의 초기 위치 설정
        Point leftThumb = new Point(3, 0);
        Point rightThumb = new Point(3, 2);
        
        StringBuilder sb = new StringBuilder();
        for(int i : numbers) {
            i -= 1; // 인덱스 조정 (0부터 시작하도록)
            int y = i == -1 ? 3 : i / 3; // 숫자의 y좌표
            int x = i == -1 ? 1 : i % 3; // 숫자의 x좌표
            boolean direction = getDirection(y, x, leftThumb, rightThumb, hand);
            if(direction) {
                sb.append('L');
                leftThumb.setPoint(y, x); // 왼손 위치 업데이트
            } else {
                sb.append('R');
                rightThumb.setPoint(y,x); // 오른손 위치 업데이트
            }
        }
        
        return sb.toString();
    }
    
    private boolean getDirection(int y, int x, Point leftThumb, Point rightThumb, String hand) {
        boolean isLeft = true;
        if(x == 0) { // 왼쪽 열 (1, 4, 7)
            isLeft = true;
        } else if(x == 2) { // 오른쪽 열 (3, 6, 9)
            isLeft = false;
        } else { // 가운데 열 (2, 5, 8, 0)
            int left = Math.abs(y - leftThumb.y) + Math.abs(x - leftThumb.x); // 왼손 거리
            int right = Math.abs(y - rightThumb.y) + Math.abs(x - rightThumb.x); // 오른손 거리
            if(left == right) { // 거리가 같은 경우
                if(hand.equals("left")) {
                    isLeft = true;
                } else {
                    isLeft = false;
                }
            } else {
                if(left < right) {
                    isLeft = true;
                } else {
                    isLeft = false;
                }
            }
        }
        return isLeft;
    }
}
