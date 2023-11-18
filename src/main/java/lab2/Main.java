package lab2;

import lab1.Athlete;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        Athlete student = new Athlete.AthleteBuilder("Joe")
                .dateOfBirth(LocalDate.of(2003, 11, 13))
                .build();

        Serializer TxtS = new TxtS();
        TxtS.serialize(student, "num1.txt");
        Athlete txtdeserialized = TxtS.deserialize("num1.txt", Athlete.class);

    }
}