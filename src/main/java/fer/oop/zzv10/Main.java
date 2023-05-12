package fer.oop.zzv10;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(PointsUtil.getForYear(2020));
            System.out.println(NewPointsUtil.getForYear(2020));
            System.out.println(StandingsUtil.orderByPoints(PointsUtil.getForYear(2020)));
            System.out.println(Translations.load());
            System.out.println(Translations.translate("Azerbaijan", "fr", Translations.load()));
            DownloadFlags.download();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
