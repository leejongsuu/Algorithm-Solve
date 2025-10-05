import java.util.*;

class Solution {
    class Genre {
        String genre;
        int totalPlay;
        
        Genre(String genre, int totalPlay) {
            this.genre = genre;
            this.totalPlay = totalPlay;
        }
    }
    
    class Album implements Comparable<Album> {
        int index;
        int play;
        Album(int index, int play) {
            this.index = index;
            this.play = play;
        }
        
        @Override
        public int compareTo(Album o) {
            if(o.play == this.play) return this.index - o.index;
            else return o.play - this.play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        int len = genres.length;
        
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<Album>> albumMap = new HashMap<>();
        
        for(int i = 0; i < len; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            albumMap.computeIfAbsent(
                genres[i], k -> new ArrayList<>()).add(new Album(i, plays[i]));
        }
        
        List<Genre> genreList = new ArrayList<>();
        for(String genre : genreMap.keySet()) {
            genreList.add(new Genre(genre, genreMap.get(genre)));
        }
        
        Collections.sort(genreList, (a, b) -> b.totalPlay - a.totalPlay);
        
        List<Integer> result = new ArrayList<>();
        
        for(Genre g : genreList) {
            String genre = g.genre;
            
            List<Album> albums = albumMap.get(genre);
            
            Collections.sort(albums);
            
            for(int i = 0; i < 2 && i < albums.size(); i++) {
                result.add(albums.get(i).index);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}