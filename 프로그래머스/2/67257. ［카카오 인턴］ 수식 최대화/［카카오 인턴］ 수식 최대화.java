import java.util.*;

class Solution {

    long answer = 0;
    char[] operator = new char[]{'+', '-', '*'};
    boolean[] visited = new boolean[3];
    List<String> strList = new ArrayList<>();
    
    public long solution(String expression) {
        
        StringTokenizer st = new StringTokenizer(expression, "[*][+][-]", true);
        while (st.hasMoreTokens()) {
            strList.add(st.nextToken());
        }
        
        DFS(0, new char[3]);
        
        return answer;
    }
    
    private void DFS(int L, char[] combination) {
        if(L == 3) {
            List<String> tempList = new ArrayList<>(strList);
            for(int i = 0; i < 3; i++) {
                int index = tempList.indexOf(String.valueOf(combination[i]));
                while(index > 0) {
                    long leftOperand = Long.parseLong(tempList.get(index -1));
                    long rightOperand = Long.parseLong(tempList.get(index + 1));
                    char operator = tempList.get(index).charAt(0);
                    
                    long result = calculate(leftOperand, rightOperand, operator);
                    tempList.subList(index - 1, index + 2).clear();
                    tempList.add(index - 1, String.valueOf(result));
                    
                    index = tempList.indexOf(String.valueOf(combination[i]));
                }
            }
            long value = Math.abs(tempList.size() == 1 ? Long.parseLong(tempList.get(0)) : Long.parseLong(tempList.get(1)));
            answer = Math.max(answer, value);
            
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination[L] = operator[i];
                DFS(L + 1, combination);
                visited[i] = false;
            }
        }
    }
    
    public long calculate(long a, long b, char c) {
        return switch(c) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default -> -1;
        };
    }
}