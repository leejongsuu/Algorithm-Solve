class Solution {
    public int solution(int[] arr) {
        
        int result = arr[0];
        for(int i = 1; i < arr.length; i++) {
            result = (result * arr[i]) / getGcd(result, arr[i]);
        }
        
        return result;
    }
    
    public int getGcd(int a, int b) {

        int temp = 0;
            
        while(b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}