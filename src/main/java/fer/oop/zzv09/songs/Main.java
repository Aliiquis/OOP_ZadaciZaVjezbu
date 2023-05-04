package fer.oop.zzv09.songs;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Playlist p = new Playlist("Irish folk", 900);
        p.add(new Track("Dirty old old town", "The Pogues", 225)); //true
        p.add(new Track("The Galway Girl", "Sharon Shannon", 180)); //true
        p.add(new Track("Drunken Sailor", "The Irish Rovers", 176)); //true
        p.add(new Track("Whiskey in the Jar", "The Dubliners", 179)); //true
        p.add(new Track("The Green Fields of France", "The Fureys", 382)); //false
        p.add(new Track("Whiskey You're the Devil", "Shilelagh Law", 127)); //true

        printPlaylist(p);
        p.move(3, -2); //Drunken sailor becomes the first in the playlist
        p.move(2, 3); //Dirty old down goes at the end
        p.deleteAt(4); //removing Whiskey You're the Devil
        printPlaylist(p);
        p.invert();
        printPlaylist(p);

        Set<String> words = PlaylistUtil.words(p, p);
        System.out.println("Words in songs");
        for (String s : words) {
            System.out.println(s);
        }

        Map<String, Integer> wordsCounts = PlaylistUtil.wordsOccurrence(p);
        System.out.println("Words in songs (occurances):");
        for (var entry : wordsCounts.entrySet()) {
            System.out.println(entry.getKey() + " (" + entry.getValue() + ")");
        }

        Map<Integer, Map<String, Integer>> perLength = PlaylistUtil.perLength(p);
        System.out.println("Words in songs by words length:");
        for (var lengthEntry : perLength.entrySet()) {
            System.out.print(lengthEntry.getKey() + ": ");
            for (var entry : lengthEntry.getValue().entrySet()) {
                System.out.print(entry.getKey() + " (" + entry.getValue() + ") ");
            }
            System.out.println();
        }

        System.out.println();
        SortedPlaylist sp = new SortedPlaylist("Sorted " + p.getTitle());
        for (int i = 1, len = p.count(); i <= len; i++) {
            sp.add(p.trackAt(i));
        }
        sp.add(new Track("Seven Drunken Nights", "The Dubliners", 213));
        printPlaylist(sp);

        sp.invert();
        sp.add(new Track("If I Should Fall from Grace with God", "The Pogues", 140));
        printPlaylist(sp);

        sp.invert();
        printPlaylist(sp);
    }

    private static void printPlaylist(Playlist p) {
        System.out.format("%s playlist contains %d songs with total duration %ds %n",
                p.getTitle(), p.count(), p.duration());
        for (int i = 1, len = p.count(); i <= len; i++) {
            System.out.format("%d. %s dur. %d%n", i, p.trackAt(i), p.trackAt(i).getDuration());
        }
        System.out.println();
    }
}
