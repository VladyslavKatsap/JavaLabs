package lab1;

import lab1.Athlete;
import lab1.Competition;

class Position{
    private Competition competition;

    private int place;

    private Athlete athlete;

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    @Override
    public String toString() {
        return "Position{" +
                "competition=" + competition +
                ", place=" + place +
                ", athlete=" + athlete +
                '}';
    }
}