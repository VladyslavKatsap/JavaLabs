package lab3;

import lab1.Athlete;
import lab1.Competition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Athlete athlete1 = new Athlete.AthleteBuilder("Oleg")
                .dateOfBirth(LocalDate.of(2003, 1, 1))
                .build();
        Athlete athlete2 = new Athlete.AthleteBuilder("Ivan")
                .dateOfBirth(LocalDate.of(2001, 3, 28))
                .build();
        Athlete athlete3 = new Athlete.AthleteBuilder("Pavlo")
                .dateOfBirth(LocalDate.of(2005, 2, 14))
                .build();
        // Enroll the student in subjects and assign grades

        Competition bp = new Competition("Bench press", 93);
        Competition deadlift = new Competition("Deadlift", 100);
        Competition squat = new Competition("Squat", 93);
        // Додавання студентів до списку
        List<Athlete> athletes = new ArrayList<>();
        athletes.add(athlete1);
        athletes.add(athlete2);
        athletes.add(athlete3);

        // Вивід несортованих студентів
        System.out.println("Unsorted students:");
        athletes.forEach(athlete -> System.out.println(athlete.getName() + " - " + athlete.getDateOfBirth()));

        // Create an instance of SchoolService1
        ZmagServices zmagServices = new ZmagServices(athletes);

        // Test sorting by name
        System.out.println("Sorted by name:");
        zmagServices.sortAthleteByName().forEach(athlete -> System.out.println(athlete.getName()));

        // Test sorting by date of birth
        System.out.println("\nSorted by date of birth:");
        zmagServices.sortAthleteByDateOfBirth().forEach(athlete -> System.out.println(athlete.getName()));

        // Test filtering by part of the name
        System.out.println("\nFiltered by part of the name:");
        zmagServices.getByPartName("Ol").forEach(athlete -> System.out.println(athlete.getName()));

        // Test filtering by current month
        System.out.println("\nFiltered by current month:");
        zmagServices.getByCurrentMonth().forEach(athlete -> System.out.println(athlete.getName()));



    }
}