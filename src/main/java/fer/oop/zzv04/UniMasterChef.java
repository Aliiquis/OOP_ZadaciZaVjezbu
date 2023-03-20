package fer.oop.zzv04;

public class UniMasterChef {
    private CompetitionEntry[] competitionEntries;
    private int n = 0;

    public UniMasterChef(int numOfEntries) {
        this.competitionEntries = new CompetitionEntry[numOfEntries];
    }

    static Person[] getInvolvedPeople(CompetitionEntry competitionEntry) {
        Person[] toReturn = new Person[4];
        toReturn[0] = competitionEntry.getTeacher();
        for (int i = 1; i < 4; i++) {
            toReturn[i] = competitionEntry.getStudents()[i - 1];
        }
        return toReturn;
    }

    public Dessert getBestDessert() {
        double maxRating = 0.;
        Dessert bestDessert = null;
        for (CompetitionEntry ce : competitionEntries) {
            if (ce.getRating() >= maxRating) {
                maxRating = ce.getRating();
                bestDessert = ce.getDessert();
            }
        }
        return bestDessert;
    }

    public boolean addEntry(CompetitionEntry competitionEntry) {
        if (n >= competitionEntries.length) {
            return false;
        }
        for (CompetitionEntry ce : competitionEntries) {
            if (competitionEntry.equals(ce)) {
                return false;
            }
        }
        competitionEntries[n] = competitionEntry;
        n++;
        return true;
    }
}
