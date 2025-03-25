class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] result = new String[n];
        for(int i = 0; i < n; i++) {
            String sBinary = Integer.toBinaryString(arr1[i] | arr2[i]);
            sBinary = sBinary.replaceAll("1", "#").replaceAll("0", " ");
            while(sBinary.length() < n) sBinary = " " + sBinary;
            
            result[i] = sBinary;
        }
        return result;
    }
}