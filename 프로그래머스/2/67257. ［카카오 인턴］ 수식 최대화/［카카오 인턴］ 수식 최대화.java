import java.util.*;

class Solution {
    
    long answer = 0;
    char[] operator = new char[]{'+', '-', '*'};
    List<String> expressionList = new ArrayList<>();

    final int INF = 3;
    
    public long solution(String expression) {
        
        StringTokenizer st = new StringTokenizer(expression, "[-][+][*]", true);
        while(st.hasMoreTokens()) {
            expressionList.add(st.nextToken());
        }
        
        generateCombinations(0, new char[3], new boolean[3]);
        
        return answer;
    }
    
    public void generateCombinations(int L, char[] combination, boolean[] visited) {
        if(L == INF) {
            List<String> tempList = new ArrayList<>(expressionList);
            
            for(int i = 0; i < L; i++) {
                int index = tempList.indexOf(String.valueOf(combination[i]));
                while(index > -1) {
                    long rightOperand = Long.parseLong(tempList.get(index + 1));
                    long leftOperand = Long.parseLong(tempList.get(index - 1));
                    long result = calculate(leftOperand, rightOperand, combination[i]);
                    
                    tempList.subList(index - 1, index + 2).clear();
                    tempList.add(index - 1, String.valueOf(result));
                    index = tempList.indexOf(String.valueOf(combination[i]));
                }
            }
            
            answer = Math.max(answer, Math.abs(Long.parseLong(tempList.get(0))));
            return;
        }
        
        for(int i = 0; i < INF; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination[L] = operator[i];
                generateCombinations(L + 1, combination, visited);
                visited[i] = false;
            }
        }
    }
    
    public long calculate(long a, long b, char c) {
        return switch(c) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                default -> 0;
        };
    }
}