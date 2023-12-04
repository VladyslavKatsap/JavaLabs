package lab3;

import lab1.Athlete;
import lab1.Competition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StreamTest {

    public static void main(String[] args) {
        Athlete athlete1 = new Athlete.AthleteBuilder("Oleg")
                .dateOfBirth(LocalDate.of(2003, 1, 1))
                .build();
        Athlete athlete2 = new Athlete.AthleteBuilder("Ivan")
                .dateOfBirth(LocalDate.of(2001, 3, 28))
                .build();
        Athlete athlete3 = new Athlete.AthleteBuilder("Pavlo")
                .dateOfBirth(LocalDate.of(2000, 2, 14))
                .build();
        // Enroll the student in subjects and assign grades

        Competition bp = new Competition("Bench press", 93);
        Competition deadlift = new Competition("Deadlift", 100);
        Competition squat = new Competition("Squat", 93);


        // ��������� �������� �� ������
        List<Athlete> athletes = new ArrayList<>();
        athletes.add(athlete1);
        athletes.add(athlete2);
        athletes.add(athlete3);

        // ���� ������������ ��������
        System.out.println("Unsorted students:");
        athletes.forEach(athlete -> System.out.println(athlete.getName() + " - " + athlete.getDateOfBirth()));


        // Create an instance of SchoolServiceStream
        ZmagServiceStream zmagServiceStream= new ZmagServiceStream(athletes);

        // Test sorting by name
        System.out.println("Sorted by name:");
        zmagServiceStream.sortAthleteByName().forEach(athlete -> System.out.println(athlete.getName()));

        // Test sorting by date of birth
        System.out.println("\nSorted by date of birth:");
        zmagServiceStream.sortAthleteByName().forEach(athlete -> System.out.println(athlete.getName()));

        // Test filtering by part of the name
        System.out.println("\nFiltered by part of the name:");
        zmagServiceStream.getByPartName("Iv").forEach(athlete -> System.out.println(athlete.getName()));

        // Test filtering by current month
        System.out.println("\nFiltered by current month:");
        zmagServiceStream.getByCurrentMonth().forEach(athlete -> System.out.println(athlete.getName()));
    }
}