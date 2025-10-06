import java.util.*;

class Solution {
    
    long result = 0;
    boolean[] visited;
    char[] operands;
    List<String> expList = new ArrayList<>();
    
    public long solution(String expression) {
        
        Set<Character> operandSet = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(expression, "[-*+]", true);
        while(st.hasMoreTokens()) {
            String part = st.nextToken();
            expList.add(part);
            
            if(!Character.isDigit(part.charAt(0))) {
                operandSet.add(part.charAt(0));
            }
        }
        
        int size = operandSet.size();
        operands = new char[size];
        visited = new boolean[size];
        
        int i = 0;
        for(char c : operandSet) {
            operands[i++] = c;
        }
        
        makeCombination(0, size, new char[size]);
        
        return result;
    }
    
    private void solution(char[] combi) {
        List<String> tempList = new ArrayList<>(expList);

        for(char c : combi) {
            String operand = String.valueOf(c);
            int index = tempList.indexOf(operand);
            
            while(index > - 1) {
                long a = Long.parseLong(tempList.get(index - 1));
                long b = Long.parseLong(tempList.get(index + 1));
                long answer = calculate(a, b, c);
                
                tempList.add(index - 1, String.valueOf(answer));
                
                tempList.remove(index);
                tempList.remove(index);
                tempList.remove(index);
                
                index = tempList.indexOf(operand);
            }
        }
        
        result = Math.max(result, Math.abs(Long.parseLong(tempList.get(0))));
    }
    
    private void makeCombination(int L, int size, char[] combi) {
        if(L == size) {
            solution(combi);
            return;
        }
        
        for(int i = 0; i < size; i++) {
            if(!visited[i]) {
                combi[L] = operands[i];
                visited[i] = true;
                makeCombination(L + 1, size, combi);
                visited[i] = false;
            }
        }
    }
    
    private long calculate(long a, long b, char c) {
        return switch(c) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                default -> Long.MIN_VALUE;
        };
    }
}