package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Championship {
   // private Competition competition;
   // private int place;
    private String title;
    private List<Position> positions;

    public Championship(){
        positions = new ArrayList<>();
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
    public boolean addPosition(Competition competition, int place, Athlete athlete){
        Position position = new Position();
        position.setCompetition(competition);
        position.setAthlete(athlete);
        position.setPlace(place);

        return positions.add(position);
    }

    public boolean addPosition(Position position){
        return positions.add(position);
    }

    @Override
    public String toString() {
        return "Championship{" +
                "title='" + title + '\'' +
                ", positions=" + positions +
                '}';
    }
//    public Championship(Competition competition, int place) {
//        this.competition = competition;
//        this.place = place;
//    }

//    @Override
//    public String toString() {
//        return "Championship competition:" + "\n" + competition + ", place = " + place + "\n";
//    }

//    public Competition getCompetition() {
//        return competition;
//    }

//    public int getPlace() {
//        return place;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Championship championship = (Championship) obj;
//        return Objects.equals(competition, championship.competition);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(competition);
//    }

}
