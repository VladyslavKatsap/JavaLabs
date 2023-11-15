package lab1;

import java.util.Objects;

public class Championship {
    private Competition competition;
    private int place;

    public Championship(Competition competition, int place) {
        this.competition = competition;
        this.place = place;
    }

    @Override
    public String toString() {
        return "Championship competition:" + "\n" + competition + ", place = " + place + "\n";
    }

    public Competition getCompetition() {
        return competition;
    }

    public int getPlace() {
        return place;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Championship championship = (Championship) obj;
        return Objects.equals(competition, championship.competition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competition);
    }

}
