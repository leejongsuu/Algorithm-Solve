import java.util.*;

class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        
        int size = arrayA.length;
        List<Integer> listA = getDivisorList(size, arrayA);
        List<Integer> listB = getDivisorList(size, arrayB);
        
        return Math.max(isCheck(arrayA, listB), isCheck(arrayB, listA));
    }
    
    List<Integer> getDivisorList(int size, int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= arr[0]; i++) {
            boolean flag = true;
            for(int j = 0; j < size; j++) {
                if(arr[j] % i != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                list.add(0, i);
            }
        }
        return list;
    }
    
    int isCheck(int[] arr, List<Integer> list) {
        for(int divisor : list) {
            boolean flag = true;
            for(int a : arr) {
                if(a % divisor == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) return divisor;
        }
        
        return 0;
    }
}