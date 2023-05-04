package fer.oop.zzv09.songs;

import java.util.*;

public class PlaylistUtil {
    public static Set<String> words(Playlist... playlists) {
        Set<String> words = new TreeSet<>();
        for (Playlist playlist : playlists) {
            for (int i = 1; i <= playlist.count(); i++) {
                words.addAll(List.of(playlist.trackAt(i).getTitle().split(" ")));
            }
        }
        return words;
    }

    public static Map<String, Integer> wordsOccurrence(Playlist... playlists) {
        Map<String, Integer> wordMap = new TreeMap<>();
        for (Playlist playlist : playlists) {
            for (int i = 1; i <= playlist.count(); i++) {
                for (String word : playlist.trackAt(i).getTitle().split(" ")) {
                    wordMap.compute(word, (key, value) -> value == null ? 1 : value + 1);
                }
            }
        }
        return wordMap;
    }

    public static Map<Integer, Map<String, Integer>> perLength(Playlist... playlists) {
        Map<Integer, Map<String, Integer>> perLengthMap = new TreeMap<>();

        int maxLength = 0;
        for (String word : words(playlists)) {
            if (word.length() > maxLength) maxLength = word.length();
        }

        for (int i = 1; i <= maxLength; i++) {
            Map<String, Integer> occurrencesOfLength = new TreeMap<>();
            for (Playlist playlist : playlists) {
                for (int j = 1; j <= playlist.count(); j++) {
                    for (String word : playlist.trackAt(j).getTitle().split(" ")) {
                        if (word.length() == i) {
                            occurrencesOfLength.compute(word, (key, value) -> value == null ? 1 : value + 1);
                        }
                    }
                }
            }
            perLengthMap.put(i, occurrencesOfLength);
        }
        return perLengthMap;
    }
}
