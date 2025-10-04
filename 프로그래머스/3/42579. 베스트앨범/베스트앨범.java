import java.util.*;
import java.util.stream.Collectors;

class Solution {

    class GenrePlay {
        String genre;
        int totalPlay;

        GenrePlay(String genre, int totalPlay) {
            this.genre = genre;
            this.totalPlay = totalPlay;
        }
    }
    
    class Music implements Comparable<Music> {
        int index;
        int play; 

        Music(int index, int play) {
            this.index = index;
            this.play = play;
        }

        @Override
        public int compareTo(Music o) {
            if (this.play == o.play) {
                return this.index - o.index; 
            }
            return o.play - this.play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        int n = genres.length;
        
        Map<String, Integer> genreTotalPlayMap = new HashMap<>();
        Map<String, List<Music>> playMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            genreTotalPlayMap.put(genres[i], genreTotalPlayMap.getOrDefault(genres[i], 0) + plays[i]);
            playMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Music(i, plays[i]));
        }

        List<GenrePlay> genreList = new ArrayList<>();
        for (String key : genreTotalPlayMap.keySet()) {
            genreList.add(new GenrePlay(key, genreTotalPlayMap.get(key)));
        }

        Collections.sort(genreList, (a, b) -> b.totalPlay - a.totalPlay);
        
        List<Integer> result = new ArrayList<>();

        for (GenrePlay genreInfo : genreList) {
            String genre = genreInfo.genre;
            List<Music> musicList = playMap.get(genre);

            Collections.sort(musicList);

            for (int i = 0; i < musicList.size() && i < 2; i++) {
                result.add(musicList.get(i).index);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}