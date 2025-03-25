import java.util.*;

class Solution {
    public int solution(String dartResult) {

        int answer = 0;
        int len = dartResult.length();
        int i = 0, before = 0;
        while(i < len) {
            
            int score = dartResult.charAt(i) - '0';
            i++;
            if(Character.isDigit(dartResult.charAt(i))) {
                score = 10;
                i++;
            }
            
            char bonus = dartResult.charAt(i);
            switch(bonus) {
                    case 'S' -> score = (int) Math.pow(score, 1);
                    case 'D' -> score = (int) Math.pow(score, 2);
                    case 'T' -> score = (int) Math.pow(score, 3);
            }
            i++;
            
            if(i < len && !Character.isDigit(dartResult.charAt(i))) {
                char option = dartResult.charAt(i);
                if(option == '*') {
                    answer += before;
                    score *= 2;
                } else {
                    score *= -1;
                }
                i++;
            }
            before = score;
            answer += score;
        }
        
        return answer;
    }
}