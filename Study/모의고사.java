import java.util.ArrayList;

class Solution {
    
    public int[] solution(int[] answers) {
        
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] correct  = new int[3];
        
        int max = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == person1[i % person1.length]) correct[0]++;
            if(answers[i] == person2[i % person2.length]) correct[1]++;
            if(answers[i] == person3[i % person3.length]) correct[2]++;
            max = Math.max(correct[0], Math.max(correct[1], correct[2]));
        }
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for(int i = 0; i < correct.length; i++) {
            if(max == correct[i]) {
                answerList.add(i + 1);
            }
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
