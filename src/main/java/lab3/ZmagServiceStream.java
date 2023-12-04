package lab3;

import lab1.Athlete;
import lab1.Competition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ZmagServiceStream implements ZmagService{

    private List<Athlete> athletes;

    public ZmagServiceStream(List<Athlete> students){
        this.athletes = athletes;
    }

    @Override
    public List<Athlete> sortAthleteByName() {
        List<Athlete> result = new ArrayList<>(athletes);
        return result.stream()
                .sorted(Comparator.comparing(Athlete::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Athlete> sortAthleteByDateOfBirth() {
        List<Athlete> result = new ArrayList<>(athletes);
        return result.stream()
                .sorted(Comparator.comparing(Athlete::getDateOfBirth))
                .collect(Collectors.toList());
    }

    @Override
    public List<Athlete> getByPartName(String name) {
        List<Athlete> result = new ArrayList<>(athletes);
        return result.stream()
                .filter(athlete -> athlete.getName().contains(name))
                .sorted(Comparator.comparing(Athlete::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Athlete> getByCurrentMonth() {
        List<Athlete> result = new ArrayList<>(athletes);
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();

        return result.stream()
                .filter(athlete -> athlete.getDateOfBirth().getMonthValue() == currentMonth)
                .sorted(Comparator.comparing(Athlete::getName))
                .collect(Collectors.toList());
    }
}