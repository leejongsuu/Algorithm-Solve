class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량
        
        int currentHealth = health; // 현재 체력
        int lastTime = 0; // 마지막 공격 시간 
        
        for(int[] attack : attacks) {
            
            // 지난 회복량 계산
            int recoveryTime = attack[0] - lastTime - 1;
            currentHealth += recoveryTime * x;
            if(recoveryTime >= t) {
                currentHealth += (recoveryTime / t) * y;
            }
            currentHealth = Math.min(currentHealth, health);
            
            // 몬스터 공격 계산
            currentHealth -= attack[1];
            if(currentHealth <= 0) {
                return -1;
            }
            
            lastTime = attack[0];
        }
        
        return currentHealth;
    }
}