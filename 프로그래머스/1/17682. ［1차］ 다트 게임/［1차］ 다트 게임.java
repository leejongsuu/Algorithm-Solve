import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        
        int[] scores = new int[3];
        
        int answer, i, index;
        int len = dartResult.length();
        
        answer = i = index = 0;
        while(i < len) {
            
            // 1. 점수 추출
            int score = 0;
            if(Character.isDigit(dartResult.charAt(i+1))) {
                score = 10;
                i += 2;
            } else {
                score = dartResult.charAt(i) - '0';
                i++;
            }
            
            // 2. 보너스 처리
            char bonus = dartResult.charAt(i);
            if(bonus == 'S') {
                scores[index] = score;
            } else if(bonus == 'D') {
                scores[index] = (int) Math.pow(score, 2);
            } else {
                scores[index] = (int) Math.pow(score, 3);
            }
            i++;
            
            // 3. 옵션
            if(i < len) {
                char option = dartResult.charAt(i);
                if(option == '*') {
                    scores[index] *= 2;
                    if(index > 0) scores[index - 1] *= 2;
                    i++;
                } else if(option == '#') {
                    scores[index] *= -1;
                    i++;
                }
            }
            
            index++;
        }
        
        return Arrays.stream(scores).sum();
    }
}