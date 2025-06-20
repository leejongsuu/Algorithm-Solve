import java.util.*;

class Solution {
    
    int[] discount = {10, 20, 30, 40};
    List<int[]> discountList = new ArrayList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        int size = emoticons.length;
        makeCombination(0, size, new int[size]);
        
        List<int[]> answerList = new ArrayList<>();
        
        for(int[] d : discountList) {
            int price = 0;
            int subscriber = 0;
            for(int[] user : users) {
                int sum = 0;
                for(int i = 0; i < size; i++) {
                    if(d[i] >= user[0]) {
                        sum += emoticons[i] * (100 - d[i]) / 100;
                    }
                }
                if(sum >= user[1]) {
                    subscriber++;
                } else {
                    price += sum;
                }
            }
            answerList.add(new int[]{subscriber, price});
        }
        
        answerList.sort((a, b) -> {
            if(a[0] != b[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        
        return answerList.get(0);
    }
    
    void makeCombination(int L, int size, int[] combi) {
        if(L == size) {
            discountList.add(combi.clone());
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            combi[L] = discount[i];
            makeCombination(L + 1, size, combi);
        }
    }
}