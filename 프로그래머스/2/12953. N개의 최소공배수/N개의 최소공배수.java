class Solution {
    public int solution(int[] arr) {
        
        if(arr.length == 1) {
            return arr[0];
        }
        
        int mul = (arr[0] * arr[1]) / getDivide(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++) {
            mul = (mul * arr[i]) / getDivide(mul, arr[i]);
        }
        
        return mul;
    }
    
    int getDivide(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}