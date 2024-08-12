class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n).reverse();
        
        int size = sb.length();
        
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            result[i] = sb.charAt(i) - '0';
        }
        
        return result;
    }
}