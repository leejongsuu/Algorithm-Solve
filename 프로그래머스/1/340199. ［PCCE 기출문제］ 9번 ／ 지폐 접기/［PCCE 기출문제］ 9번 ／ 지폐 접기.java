class Solution {
    public int solution(int[] wallet, int[] bill) {

        int answer = 0;
        while(wallet[0] < bill[0] || wallet[1] < bill[1]) {
            if(wallet[0] < bill[1] || wallet[1] < bill[0]) {
                boolean flag = bill[0] >= bill[1];
                if(flag) bill[0] /= 2;
                else bill[1] /= 2;
                answer++;
            } else {
                break;
            }
        } 
        
        return answer;
    }
}