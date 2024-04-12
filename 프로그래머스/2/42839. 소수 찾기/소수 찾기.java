import java.util.*;

class Solution {
    
    private Set<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        generateNumber("", numbers);
        
        for(int num : numberSet) {
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    private void generateNumber(String prefix, String remaining) {
        
        if(!prefix.isEmpty()) {
            numberSet.add(Integer.parseInt(prefix));
        }
        for(int i=0; i<remaining.length(); i++) {
            generateNumber(prefix + remaining.charAt(i), remaining.substring(0,i) + remaining.substring(i+1));
        }
    }
    
    private boolean isPrime(int num) {
        
        if(num == 0 || num == 1) return false;
        
        for(int i=2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}