import java.util.*;

class Solution {
    class Info implements Comparable<Info> {
        String fileName;
        String head;
        int number;
        
        public Info(String fileName, String head, int number) {
            this.fileName = fileName;
            this.head = head;
            this.number = number;
        }
        
        @Override
        public int compareTo(Info o) {
            String a = this.head.toLowerCase();
            String b = o.head.toLowerCase();
            
            if(a.equals(b)) return this.number - o.number;
            else return a.compareTo(b);
        }
    }
    public String[] solution(String[] files) {
        
        int len = files.length;
        
        String[] result = new String[len];
        Info[] infos = new Info[len];
        
        for(int i = 0; i < len; i++) {
            int lt = 0, rt = 0;
            int fileLength = files[i].length();
            while(rt < fileLength && !Character.isDigit(files[i].charAt(rt))) {
                rt++;
            }
            String head = files[i].substring(lt, rt);
            lt = rt;
            
            int number = 0;
            while(rt < fileLength && Character.isDigit(files[i].charAt(rt))) {
                rt++;
            }
            number = Integer.parseInt(files[i].substring(lt, rt));
            
            infos[i] = new Info(files[i], head, number);
        }
        
        Arrays.sort(infos);
        
        for(int i = 0; i < len; i++) {
            result[i] = infos[i].fileName;
        }
        
        
        return result;
    }
}