package fer.oop.zi_priprema;

import java.nio.file.Path;

public final class Util {

    private Util() {
    }

    public static Integer parseOrDefault(String val, Integer defaultValue) {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException | NullPointerException e) {
            return defaultValue;
        }
    }

    public static Long parseOrDefault(String val, Long defaultValue) {
        try {
            return Long.parseLong(val);
        } catch (NumberFormatException | NullPointerException e) {
            return defaultValue;
        }
    }

    public static Path ensureDirectory(Path of) {
        if (!of.toFile().exists()) of.toFile().mkdirs();
        return of;
    }
}
