class Solution {
    public int solution(int n) {
        
        StringBuffer sb = new StringBuffer();
        while(n > 2) {
            int remain = n % 3;
            n /= 3;
            sb.insert(0, String.valueOf(remain));
        }
        String str = sb.insert(0, String.valueOf(n)).toString();
        
        int sum =0;
        for(int i = 0; i < str.length(); i++) {
            sum += (int) Math.pow(3, i) * (str.charAt(i) - '0');    
        }
        
        return sum;
    }
}