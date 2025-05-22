import java.util.*;

class Solution {
    public long solution(int[] weights) {
        // 1) 무게별 빈도 계산
        Map<Integer, Long> freq = new HashMap<>();
        for (int w : weights) {
            freq.put(w, freq.getOrDefault(w, 0L) + 1);
        }

        long ans = 0;

        // 2) 같은 무게끼리 조합: C(n,2)
        for (long cnt : freq.values()) {
            ans += cnt * (cnt - 1) / 2;
        }

        // 3) 다른 무게 조합: (d1,d2) 쌍 중 d1/d2>1인 경우만
        //    (3/2), (4/2), (4/3)
        for (Map.Entry<Integer, Long> e : freq.entrySet()) {
            int w = e.getKey();
            long cntW = e.getValue();

            // 3/2 비율: w2 = w * 3/2
            int t1 = w * 3;
            if (t1 % 2 == 0) {
                int w2 = t1 / 2;
                Long cntW2 = freq.get(w2);
                if (cntW2 != null) {
                    ans += cntW * cntW2;
                }
            }

            // 4/2 비율: w2 = w * 2
            int w2 = w * 2;
            Long cntW2 = freq.get(w2);
            if (cntW2 != null) {
                ans += cntW * cntW2;
            }

            // 4/3 비율: w2 = w * 4/3
            int t3 = w * 4;
            if (t3 % 3 == 0) {
                int w3 = t3 / 3;
                Long cntW3 = freq.get(w3);
                if (cntW3 != null) {
                    ans += cntW * cntW3;
                }
            }
        }

        return ans;
    }
}
