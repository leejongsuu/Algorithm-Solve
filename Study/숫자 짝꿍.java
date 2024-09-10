class Solution {
    public String solution(String X, String Y) {
        
        int[] x = new int[10];
        int[] y = new int[10];
        for(char num : X.toCharArray()) x[num - '0']++;
        for(char num : Y.toCharArray()) y[num - '0']++;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            if(x[i] > 0 && y[i] > 0) {
                sb.append(String.valueOf(i).repeat(Math.min(x[i], y[i])));
            }
        }
        
        if(sb.length() == 0) {
            return "-1";
        }
        else if(sb.charAt(0) == '0'){
            return "0";
        } else {
            return sb.toString();
        }
    }
}
