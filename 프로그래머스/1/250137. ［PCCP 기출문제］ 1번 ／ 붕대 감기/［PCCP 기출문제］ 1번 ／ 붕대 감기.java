class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량
        int len = attacks.length; // 몬스터 공격 횟수
        int maxTime = attacks[len-1][0]; // 몬스터의 마지막 공격 시간
        int hp = health; // 현재 체력량
        int success = 0; // 연속 성공
        
        for(int lt = 0, rt = 0; lt <= maxTime; lt++) { // 1초 간격으로 반복문을 돔
            if(lt < attacks[rt][0]) {
                success++;
                if(hp < health) {
                    hp += x;
                    if(success >= t) {
                        hp += y;
                        success = 0;
                    }
                    if(hp > health) {
                        hp = health;
                    }
                }
            } else {
                hp -= attacks[rt][1];
                success = 0;
                if(hp <= 0) {
                    return -1;
                }
                rt++;
            }
        }
        
        return hp;
    }
}