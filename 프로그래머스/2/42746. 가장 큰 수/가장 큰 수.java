import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 정수를 문자열로 변환하여 비교하기 위한 Comparator 구현
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 두 문자열을 합쳐서 비교
                return (b + a).compareTo(a + b);
            }
        };

        // 정수를 문자열로 변환한 후 정렬
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, comp);

        // 정렬된 문자열 배열을 이어 붙여서 결과 생성
        StringBuilder sb = new StringBuilder();
        for (String num : strNumbers) {
            sb.append(num);
        }

        // 0으로 시작하는 경우 예외 처리
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}