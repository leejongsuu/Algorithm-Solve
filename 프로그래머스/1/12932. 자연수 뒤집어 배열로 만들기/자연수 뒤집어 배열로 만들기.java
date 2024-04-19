class Solution {
    public int[] solution(long n) {
        
        String strNum = String.valueOf(n);
        int len = strNum.length();
        
        // 배열의 size를 숫자의 길이만큼 할당
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++) {
            answer[i] = strNum.charAt(len-1-i)-'0';
        }
        
        return answer;
    }
}