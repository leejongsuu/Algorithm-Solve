import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        // 해시셋을 사용하여 폰켓몬 종류 세기
        HashSet<Integer> ponketmon = new HashSet<>();
        for (int num : nums) {
            ponketmon.add(num);
        }

        // 폰켓몬 종류 수와 선택할 수 있는 최대 마리 수(N/2) 중 작은 값 반환
        return Math.min(ponketmon.size(), nums.length / 2);
    }
}
