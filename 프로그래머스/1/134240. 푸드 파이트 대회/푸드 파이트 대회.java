class Solution {
    public String solution(int[] food) {
        
        StringBuffer sb = new StringBuffer();
        
        for(int i = 1; i < food.length; i++) {
            String str = String.valueOf(i).repeat(food[i] / 2);
            sb.append(str);
        }
        
        String answer = sb.toString();
        answer += "0";
        answer += sb.reverse().toString();
        
        return answer;
    }
}