class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int beforeTime = 0;
        int currentHealth = health;
        for(int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int demage = attacks[i][1];
            
            int time = attackTime - beforeTime - 1;
            currentHealth += time * x;
            currentHealth += (time / t) * y;
            currentHealth = Math.min(health, currentHealth);
            
            currentHealth -= demage;
            
            if(currentHealth <= 0) {
                return -1;
            }
            
            beforeTime = attackTime;
        }
        
        return currentHealth;
    }
}