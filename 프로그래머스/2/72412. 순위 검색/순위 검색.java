import java.util.*;

class Solution {
    
    final String[] languages = {"cpp", "java", "python", "-"};
    final String[] work = {"backend", "frontend", "-"};
    final String[] experience = {"junior", "senior", "-"};
    final String[] food = {"chicken", "pizza", "-"};
    
    Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        
        int len = query.length;
        int[] result = new int[len];
        
        makeCombination(0, new int[4]);
        
        for(String str : info) {
            String[] parts = str.split(" ");
            inputInfo(0, new String[4], parts);
        }
        
        for(String key : map.keySet()) {
            List<Integer> scores = map.get(key);
            Collections.sort(scores);
        }
        
        for(int i = 0; i < len; i++) {
            String[] parts = query[i].replace(" and ", "").split(" ");
            
            String key = parts[0];
            int score = Integer.parseInt(parts[1]);
            
            List<Integer> scoreList = map.get(key);
            
            int index = binarySearch(score, scoreList);
            
            result[i] = scoreList.size() - index;
        }
        
        return result;
    }
    
    private void makeCombination(int L, int[] combi) {
        if(L == 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(languages[combi[0]]);
            sb.append(work[combi[1]]);
            sb.append(experience[combi[2]]);
            sb.append(food[combi[3]]);
            
            map.put(sb.toString(), new ArrayList<>());
            
            return;
        }
        
        if(L == 0) {
            for(int i = 0; i < 4; i++) {
                combi[L] = i;
                makeCombination(L + 1, combi);
            }
        } else {
            for(int i = 0; i < 3; i++) {
                combi[L] = i;
                makeCombination(L + 1, combi);
            }
        }
    }
    
    private void inputInfo(int L, String[] combi, String[] parts) {
        if(L == 4) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 4; i++) {
                sb.append(combi[i]);
            }
            
            String key = sb.toString();
            int score = Integer.parseInt(parts[4]);
            
            map.get(key).add(score);
            
            return;
        }
        
        combi[L] = parts[L];
        inputInfo(L + 1, combi, parts);
        
        combi[L] = "-";
        inputInfo(L + 1, combi, parts);
    }
    
    private int binarySearch(int score, List<Integer> list) {
        int lt = 0, rt = list.size();
        
        while(lt < rt) {
            int mid = (lt + rt) / 2;
            
            if(list.get(mid) < score) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        
        return lt;
    }
}