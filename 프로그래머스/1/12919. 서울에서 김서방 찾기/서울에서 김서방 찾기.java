import java.util.List;

class Solution {
    public String solution(String[] seoul) {
        int index = List.of(seoul).indexOf("Kim");
        
        return "김서방은 " + index + "에 있다";
    }
}