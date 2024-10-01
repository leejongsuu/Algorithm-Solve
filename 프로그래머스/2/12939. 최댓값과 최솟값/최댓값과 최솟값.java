import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] splited = s.split(" ");
        int size = splited.length;
        
        int[] numArr = new int[size];
        for(int i = 0; i < size; i++) {
            numArr[i] = Integer.parseInt(splited[i]);
        }
        
        Arrays.sort(numArr);
        
        String result = String.valueOf(numArr[0]) + " " + String.valueOf(numArr[size -1]);
        
        return result;
    }
}