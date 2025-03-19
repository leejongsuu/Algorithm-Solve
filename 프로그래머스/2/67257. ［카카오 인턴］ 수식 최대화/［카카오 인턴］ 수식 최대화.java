import java.util.*;

class Solution {
    
    long answer = 0;
    char[] operators = {'+', '*', '-'};
    boolean[] visited = new boolean[3];
    List<String> expressionList = new ArrayList<>();
    
    public long solution(String expression) {
        
        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        while(st.hasMoreTokens()) {
            expressionList.add(st.nextToken());
        }
        
        makePriorityOperator(0, new char[3]);
        
        return answer;
    }
    
    public void makePriorityOperator(int L, char[] prOperators) {
        if(L == 3) {
            answer = Math.max(answer, calculatePrize(prOperators, new ArrayList<>(expressionList)));
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            if(!visited[i]) {
                visited[i] = true;
                prOperators[L] = operators[i];
                makePriorityOperator(L + 1, prOperators);
                visited[i] = false;
            }
        }
    }
    
    public long calculatePrize(char[] prOperators, List<String> list) {
        for(int i = 0; i < 3; i++) {
            while(true) {
                String operator = String.valueOf(prOperators[i]);
                int index = list.indexOf(operator);
                
                if(index < 0) break;
                else {
                    long a = Long.parseLong(list.get(index - 1));
                    long b = Long.parseLong(list.get(index + 1));
                    String result = String.valueOf(calculateOperator(a, b, prOperators[i]));
                    list.add(index - 1, result);
                    list.subList(index, index + 3).clear();
                }
            }
        }
        return Math.abs(Long.parseLong(list.get(0)));
    }
    
    public long calculateOperator(long a, long b, char c) {
        return switch(c) {
            case '*' -> a * b;
            case '+' -> a + b;
            case '-' -> a - b;
            default -> -1;
        };
    } 
}