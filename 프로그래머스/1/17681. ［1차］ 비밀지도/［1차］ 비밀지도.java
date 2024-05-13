class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        char[][] map = new char[n][n];
        for(int i = 0; i < n; i++) {
            int j = n - 1;
            while(j >= 0) {
                if(arr1[i] % 2 == 1 || arr2[i] % 2 == 1) map[i][j] = '#';
                else map[i][j] = ' ';
                arr1[i] /= 2;
                arr2[i] /= 2;
                j--;
            }
        }
        
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            answer[i] = String.valueOf(map[i]);
        }
        return answer;
    }
}