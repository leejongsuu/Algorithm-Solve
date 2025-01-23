import java.util.*;

class Solution {
    
    class Album implements Comparable<Album> {
        String genre;
        int play;
        int index;
        
        public Album(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }
        
        public Album(int play, int index) {
            this.play = play;
            this.index = index;
        }
        
        
        @Override
        public int compareTo(Album o) {
            return o.play - this.play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        int N = genres.length;
        
        for(int i = 0; i < N; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Album> list = new ArrayList<>();
        for(String key : map.keySet()) {
            list.add(new Album(key, map.get(key)));
        }
        
        Collections.sort(list);
                
        List<Integer> result = new ArrayList<>();
        for(Album album : list) {
            List<Album> tempList = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                if(album.genre.equals(genres[i])) {
                    tempList.add(new Album(plays[i], i));
                }
            }
            
            Collections.sort(tempList);
            
            int limit = 2;
            for(Album temp : tempList) {
                if(limit == 0) {
                    break;
                }
                result.add(temp.index);
                limit--;
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
   }
}