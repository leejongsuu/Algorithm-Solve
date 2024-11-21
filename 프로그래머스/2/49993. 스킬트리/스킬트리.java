import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int result = 0;
        
        Set<Character> set = new HashSet<>();
        for(char c : skill.toCharArray()) {
            set.add(c);
        }
        
        for(String skill_tree : skill_trees) {
            int index = 0;
            boolean flag = true;
            for(char c : skill_tree.toCharArray()) {
                if(!set.contains(c)) continue;
                
                if(skill.charAt(index) == c) {
                    index++;
                } else {
                    flag = false;
                    break;
                }
            }
            
            if(flag) result++;
        }
        
        return result;
    }
}