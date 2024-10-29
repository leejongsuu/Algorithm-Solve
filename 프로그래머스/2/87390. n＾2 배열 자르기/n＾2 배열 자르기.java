class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] result = new int[(int) (right - left) + 1];

        for(int i = 0; i < result.length; i++) {
            int row = (int) (left / n + 1);
            int col = (int) (left % n + 1);
            if(row < col) {
                result[i] = col;
            } else {
                result[i] = row;
            }
            
            left++;
        }
        
        return result;
    }
}