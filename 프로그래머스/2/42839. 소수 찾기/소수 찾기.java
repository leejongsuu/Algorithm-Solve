import java.util.HashSet;
import java.util.Set;

class Solution {

    Set<Integer> candidateSet = new HashSet<>();
    boolean[] visited; 

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        dfs("", numbers);
        
        int primeCount = 0;
        for (int candidate : candidateSet) {
            if (isPrime(candidate)) {
                primeCount++;
            }
        }
        
        return primeCount;
    }

    public void dfs(String currentStr, String numbers) {
        if (!currentStr.isEmpty()) {
            candidateSet.add(Integer.parseInt(currentStr));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(currentStr + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        if (num == 2) {
            return true;
        }
        
        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false; 
            }
        }
        
        return true; 
    }
}