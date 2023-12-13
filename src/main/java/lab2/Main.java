package lab2;

import lab1.Athlete;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        Athlete athlete = new Athlete.AthleteBuilder("Andriy")
                .dateOfBirth(LocalDate.of(2003, 11, 13))
                .build();
        System.out.println(athlete);
        Serializer TxtS = new TxtS();
        TxtS.serialize(athlete, "num1.txt");
        Athlete txtdeserialized = TxtS.deserialize("num1.txt", Athlete.class);

//        Serializer jsonS = new JsonS();
//        jsonS.serialize(athlete, "athlete.json");
//        Athlete deserializedAth = jsonS.deserialize("athlete.json", Athlete.class);

//        Serializer XmlS = new XmlS();
//        XmlS.serialize(athlete, "athlete.xml");
//        Athlete deserialized = XmlS.deserialize("athlete.xml", Athlete.class);
    }
}