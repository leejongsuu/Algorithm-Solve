import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        int i, index;
        int len = dartResult.length();
        
        i = index = 0;
        
        int[] scores = new int[3];
        
        while(i < len) {
            int score = 0;
            if(Character.isDigit(dartResult.charAt(i+1))) {
                score = 10;
                i+=2;
            } else {
                score = dartResult.charAt(i) - '0';
                i++;
            }
            
            char bonus = dartResult.charAt(i);
            if(bonus == 'S') {
                scores[index] = score;
            } else if(bonus == 'D') {
                scores[index] = score * score;
            } else if(bonus == 'T') {
                scores[index] = score * score * score;
            }
            i++;
            
            if(i < len) {
                char option = dartResult.charAt(i);
                if(option == '*') {
                    scores[index] *=2;
                    if(index > 0) {
                        scores[index-1] *=2;
                    }
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