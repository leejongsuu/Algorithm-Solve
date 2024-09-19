class Solution {
    public String solution(String s, String skip, int index) {
        // skip에 포함된 알파벳을 체크하기 위한 boolean 배열
        boolean[] alphabet = new boolean[26];
        for (char c : skip.toCharArray()) {
            alphabet[c - 'a'] = true;
        }

        int len = s.length();
        char[] result = new char[len];
        
        // 각 문자를 변환
        for (int i = 0; i < len; i++) {
            char word = s.charAt(i);
            int j = word - 'a';
            int cnt = 0;
            while(cnt < index) {
            // index만큼 뒤의 알파벳을 찾음, skip에 포함된 알파벳은 건너뜀
                if(!alphabet[(++j) % 26]) {
                    cnt++;
                }
            }
            // 변환된 문자를 결과 배열에 저장
            result[i] = (char) (j + 'a');
        }
        
        // 결과 문자열을 생성하여 반환
        return String.valueOf(result);
    }
}
