import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        
        int[][] pattern = new int[][]{{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] person =new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == pattern[0][i % 5]) person[0]++;
            if(answers[i] == pattern[1][i % 8]) person[1]++;
            if(answers[i] == pattern[2][i % 10]) person[2]++;
        }
        
        int max = Math.max(person[0], Math.max(person[1], person[2]));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(person[i] == max) list.add(i+1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}