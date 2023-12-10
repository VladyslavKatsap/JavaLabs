package lab3;

import jakarta.validation.Validator;
import lab1.Athlete;

import java.time.LocalDate;
import java.util.*;

public class ZmagServices implements ZmagService {

    private List<Athlete> athletes;

    public ZmagServices(List<Athlete> athletes){
        this.athletes = athletes;
    }


    @Override
    public List<Athlete> sortAthleteByName() {
        List<Athlete> result = new ArrayList<>(athletes);
        result.sort(Comparator.comparing(Athlete::getName));
        return result;
    }

    @Override
    public List<Athlete> sortAthleteByDateOfBirth() {
        List<Athlete> result = new ArrayList<>(athletes);
        result.sort(Comparator.comparing(Athlete::getDateOfBirth));
        return result;
    }

    @Override
    public List<Athlete> getByPartName(String name) {
        SortedSet<Athlete> matchingAthletes = new TreeSet<>();

        for (Athlete athlete : athletes) {
            if (athlete.getName().contains(name)) {
                matchingAthletes.add(athlete);
            }
        }

       // Collections.sort(matchingAthletes);
        return new ArrayList<>(matchingAthletes);
    }

    @Override
    public List<Athlete> getByCurrentMonth() {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();

        List<Athlete> athletesInCurrentMonth = new ArrayList<>();

        for (Athlete athlete : athletes) {
            LocalDate athleteDateOfBirth = athlete.getDateOfBirth();
            if (athleteDateOfBirth.getMonthValue() == currentMonth) {
                athletesInCurrentMonth.add(athlete);
            }
        }

        athletesInCurrentMonth.sort(Comparator.comparing(Athlete::getName));

        return athletesInCurrentMonth;
    }
}