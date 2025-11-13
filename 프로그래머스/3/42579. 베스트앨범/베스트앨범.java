import java.util.*;

class Solution {
    
    class Music implements Comparable<Music> {
        int id;
        int play;
        
        Music(int id, int play) {
            this.id = id;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music o) {
            if(o.play == this.play) {
                return this.id - o.id;
            }
            return o.play - this.play;
        }
    }
    
    
    class Genre implements Comparable<Genre> {
        String genre;
        int totalPlay;
        
        Genre(String genre, int totalPlay) {
            this.genre = genre;
            this.totalPlay = totalPlay;
        }
        
        @Override
        public int compareTo(Genre o) {
            return o.totalPlay - this.totalPlay;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {

        int len = genres.length;
        
        Map<String, List<Music>> map = new HashMap<>();
        Map<String, Integer> genreMap = new HashMap<>();
        
        for(int i = 0; i < len; i++) {
            map.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Music(i, plays[i]));
            genreMap.merge(genres[i], plays[i], Integer::sum);
        }
        
        List<Genre> genreList = new ArrayList<>();
        for(String genre : genreMap.keySet()) {
            genreList.add(new Genre(genre, genreMap.get(genre)));
        }
        
        Collections.sort(genreList);
        
        List<Integer> result = new ArrayList<>();
        
        for(Genre genre : genreList) {
            List<Music> list = map.get(genre.genre);
            Collections.sort(list);
            
            int size = Math.min(2, list.size());
            for(int i = 0; i < size; i++) {
                result.add(list.get(i).id);
            }
        }
    
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}