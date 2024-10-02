class Solution {
    public int solution(int n) {
        int a = Integer.bitCount(n);
        while(true) {
            n++;
            if(a == Integer.bitCount(n)) {
                return n;
            }
        }
    }
}