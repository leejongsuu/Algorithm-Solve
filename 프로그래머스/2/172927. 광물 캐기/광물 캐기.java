import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {

        int totalPicks = picks[0] + picks[1] + picks[2];
        int len = Math.min((minerals.length + 4) / 5, totalPicks);
        List<int[]> blocks = new ArrayList<>();
        
        for(int i = 0; i < len; i++) {
            int dia = 0, iron = 0, stone = 0;
            for(int j = i * 5; j < Math.min(minerals.length, (i + 1) * 5); j++) {
                if(minerals[j].equals("diamond")) dia++;
                else if(minerals[j].equals("iron")) iron++;
                else stone++;
            }
            blocks.add(new int[]{dia, iron, stone});
        }
        
        blocks.sort((a, b) -> (b[0] * 25 + b[1] * 5 + b[0]) - (a[0] * 25 + a[1] * 5 + a[0]));
        
        int fatigue = 0;
        int pickType = 0;
        
        int[][] fatigueTable = {
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}
        };
        
        for(int[] block : blocks) {
            while(pickType < 3 && picks[pickType] == 0) {
                pickType++;
            }
            if(pickType == 3) break;
            
            fatigue += block[0] * fatigueTable[pickType][0];
            fatigue += block[1] * fatigueTable[pickType][1];
            fatigue += block[2] * fatigueTable[pickType][2];
            
            picks[pickType]--;
        }
        
        return fatigue;
    }
}