package lab1;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Competition benchPress = new Competition("Bench press", 93);
        Competition deadlift = new Competition("Deadlift", 100);
        Competition squat = new Competition("Squat", 86);

        Athlete athlete = new Athlete.AthleteBuilder("Igor")
                .dateOfBirth(LocalDate.of(2004, 7, 14))
                .build();

//        Championship championship = new Championship();
//        championship.setTitle("First");
//        Position position = new Position();
//        position.setCompetition(benchPress);
//        position.setAthlete(athlete);
//        position.setPlace(1);
//        championship.addPosition(position);
//        athlete.championshipd(bench_press, 1);
//        athlete.championshipd(deadlift, 3);
//        athlete.championshipd(squat, 2);

//        System.out.println("Athlete Info:");
//        System.out.println(athlete);

//        System.out.println(championship);
        System.out.println("Athlete Info:");
        System.out.println(athlete);

        try {
            Athlete athlete1 = new Athlete.AthleteBuilder("Kate")
                    .dateOfBirth(LocalDate.of(2025, 10, 15))
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }
}
