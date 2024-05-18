class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int lt = 0, rt =0;
        for(String str : goal) {
            if(lt < cards1.length && cards1[lt].equals(str)) lt++;
            else if(rt < cards2.length && cards2[rt].equals(str)) rt++;
            else return "No";
        }
        
        return "Yes";
    }
}