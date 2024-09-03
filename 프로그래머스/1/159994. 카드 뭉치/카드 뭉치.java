class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        int len1 = cards1.length;
        int len2 = cards2.length;
        int lt = 0, rt =0;
        for(String word : goal) {
            if(lt < len1 && word.equals(cards1[lt])) {
                lt++;
            } else if(rt < len2 && word.equals(cards2[rt])) {
                rt++;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}