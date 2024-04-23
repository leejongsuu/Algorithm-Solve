import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 9 * (10) / 2;
        return answer - Arrays.stream(numbers).sum();
    }
}