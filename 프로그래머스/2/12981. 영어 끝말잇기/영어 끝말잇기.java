import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] result = new int[2];
        
        HashSet<String> wordSet = new HashSet<>();
        char before = words[0].charAt(0);
        
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if(before != word.charAt(0) || wordSet.contains(word))  {
                result[0] = (i % n) + 1;
                result[1] = (i / n) + 1;
                break;
            }
            
            wordSet.add(word);
            before = word.charAt(word.length() - 1);
        }
        
        return result;
    }
}