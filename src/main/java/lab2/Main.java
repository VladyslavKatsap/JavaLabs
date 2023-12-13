package lab2;

import lab1.Athlete;

import java.io.IOException;
import java.time.LocalDate;
import java.io.File;
public class Main {
    public static void main(String[] args) throws IOException {
        Athlete athlete = new Athlete.AthleteBuilder("Vasyl")
                .dateOfBirth(LocalDate.of(2003, 11, 13))
                .build();

        txtTest(athlete);
    }
    public static void txtTest(Athlete athlete) {
        TxtSerializer<Athlete> ser = new TxtSerializer<Athlete>();
        File file = new File("num1.txt");
        System.out.println(ser.readFromFile(file, Athlete.class));
    }
}