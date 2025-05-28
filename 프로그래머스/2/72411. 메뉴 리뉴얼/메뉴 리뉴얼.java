import java.util.*;

class Solution {
    class Menu implements Comparable<Menu> {
        String menu;
        int count;
        
        public Menu(String menu, int count) {
            this.menu = menu;
            this.count = count;
        }
        
        @Override
        public int compareTo(Menu o) {
            return o.count - this.count;
        }
    }
    public String[] solution(String[] orders, int[] course) {
        
        // 1. course별 조합을 세는 맵
        Map<Integer, Map<String, Integer>> countMap = new HashMap<>();
        for(int cnt : course) {
            countMap.put(cnt, new HashMap<>());
        }
        
        // 2. 각 order에 대해, 모든 course 길이 조합 생성
        for(String order : orders) {
            char[] ch = order.toCharArray();
            Arrays.sort(ch);
            
            for(int cnt : course) {
                if(ch.length < cnt) continue;
                makeCombination(0, 0, cnt, new char[cnt], ch, countMap.get(cnt));
            }
        }
        
        List<String> resultList = new ArrayList<>();
        
        // 3. 길이 별로 빈도 높은 메뉴 선정
        for(int cnt : course) {
            Map<String, Integer> map = countMap.get(cnt);
            if(map.isEmpty()) continue;
            
            List<Menu> menuList = new ArrayList<>();
            for(String key : map.keySet()) {
                int value = map.get(key);
                if(map.get(key) > 1) {
                    menuList.add(new Menu(key, value));
                }
            }
            
            if(menuList.isEmpty()) continue;
            
            Collections.sort(menuList);
            int maxCount = menuList.get(0).count;
            for(Menu menu : menuList) {
                if(menu.count < maxCount) {
                    break;
                }
                resultList.add(menu.menu);
            }
        }
        
        Collections.sort(resultList);
        
        return resultList.toArray(new String[0]);
    }
    
    void makeCombination(int L, int start, int cnt, char[] temp, char[] origin, Map<String, Integer> map) {
        if(L == cnt) {
            String key = String.valueOf(temp);
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        
        for(int i = start; i < origin.length; i++) {
            temp[L] = origin[i];
            makeCombination(L + 1, i + 1, cnt, temp, origin, map);
        }
    }
}