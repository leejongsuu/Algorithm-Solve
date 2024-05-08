class Solution {
    public int solution(int n) {
        
        String a = "";
        while(n > 0) {
            a += n % 3;
            System.out.println(a);
            n /= 3;
        }
        
        return Integer.parseInt(a, 3);
    }
}