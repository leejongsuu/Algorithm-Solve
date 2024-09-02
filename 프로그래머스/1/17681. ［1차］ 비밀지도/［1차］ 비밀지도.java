class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] result = new String[n];
        
        for(int i = 0; i < n; i++) {
            String binary = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
            binary = binary
                .substring(16 - n)
                .replaceAll("1", "#")
                .replaceAll("0", " ");
            
            result[i] = binary;
        }
        
        return result;
    }
}