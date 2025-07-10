class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dPtr = n - 1, pPtr = n - 1;
        
        while(dPtr >= 0 || pPtr >= 0) {
            while(dPtr >= 0 && deliveries[dPtr] == 0) dPtr--;
            while(pPtr >= 0 && pickups[pPtr] == 0) pPtr--;
            
            if(dPtr < 0 && pPtr < 0) break;
            
            int distance = Math.max(dPtr, pPtr);
            
            answer += (distance + 1) * 2;
            
            int capRemain = cap;
            while(capRemain > 0 && dPtr >= 0) {
                int deliver = Math.min(capRemain, deliveries[dPtr]);
                deliveries[dPtr] -= deliver;
                capRemain -= deliver;
                if(deliveries[dPtr] == 0) {
                    dPtr--;
                }
            }
            
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