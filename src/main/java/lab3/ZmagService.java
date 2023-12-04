package lab3;

import lab1.Athlete;

import java.util.List;

public interface ZmagService {
    List<Athlete> sortAthleteByName();
    List<Athlete> sortAthleteByDateOfBirth();
    List<Athlete> getByPartName(String name);
    List<Athlete> getByCurrentMonth();
}