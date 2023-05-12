package fer.oop.zzv10;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public class VotingFilter implements DirectoryStream.Filter<Path> {
    @Override
    public boolean accept(Path entry) throws IOException {
        return entry.toString().endsWith("-jury.txt") || entry.toString().endsWith("-televoting.txt");
    }
}
