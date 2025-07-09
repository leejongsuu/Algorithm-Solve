import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int dPtr = n - 1, pPtr = n - 1;
        
        while(dPtr >= 0 || pPtr >= 0) {
            // 가장 멀리까지 가야 할 집 인덱스
            while(dPtr >= 0 && deliveries[dPtr] == 0) dPtr--;
            while(pPtr >= 0 && pickups[pPtr] == 0) pPtr--;
            
            if(dPtr < 0 && pPtr < 0) break;
            
            int distance = Math.max(dPtr, pPtr);
            
            // 왕복 거리 누적
            answer += (distance + 1) * 2;
            
            // 배달
            int capRemain = cap;
            while(capRemain > 0 && dPtr >= 0) {
                int delivery = Math.min(capRemain, deliveries[dPtr]);
                deliveries[dPtr] -= delivery;
                capRemain -= delivery;
                if(deliveries[dPtr] == 0) {
                    dPtr--;
                }
            }
            
            // 수거
            capRemain = cap;
            while(capRemain > 0 && pPtr >= 0) {
                int pickup = Math.min(capRemain, pickups[pPtr]);
                pickups[pPtr] -= pickup;
                capRemain -= pickup;
                if(pickups[pPtr] == 0) {
                    pPtr--;
                }
            }
        }
        
        return answer;
    }
}