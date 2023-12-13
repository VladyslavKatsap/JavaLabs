package lab1;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;


public class Athlete implements Comparable<Athlete> {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // public void setChampionships(List<Championship> enrollments) {
    //   this.championships = championships;
    //}

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
    //private List<Championship> championships;

    private Athlete(AthleteBuilder builder) {
        //this.championships = new ArrayList<>();
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public Athlete(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", date='" + dateOfBirth + '\''+
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Athlete athlete = (Athlete) obj;
        return dateOfBirth == athlete.dateOfBirth && Objects.equals(name, athlete.name);// && Objects.equals(championships, athlete.championships);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth);
    }

    @Override
    public int compareTo(Athlete athlete) {
        return this.name.compareTo(athlete.name);
    }


//    public boolean hasChampForComp(String subjectName) {
//        return getChampionships().stream()
//                .anyMatch(champ -> champ.getCompetition().getName().equals(subjectName));
//    }

//    public double getChampPlaseForComp(String subjectName) {
//        return getChampionships().stream()
//                .filter(enrollment -> enrollment.getCompetition().getName().equals(subjectName))
//                .findFirst()
//                .map(Championship::getPlace)
//                .orElse(0);
//    }

//    public double getAveragePlace(){
//
//        double totalGrade = 0.0;
//        for (Championship championship : championships) {
//            totalGrade += championship.getPlace();
//        }
//
//        return totalGrade / championships.size();
//    }

    public static class AthleteBuilder {
        private String name;
        private LocalDate dateOfBirth;

        public AthleteBuilder(String name) {
            this.name = name;
        }

        public AthleteBuilder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        private void validate(Athlete athlete) {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

            Set<String> validationMessages = new HashSet<>();
            Set<ConstraintViolation<Athlete>> violations = validator.validate(athlete);

            for (ConstraintViolation<Athlete> violation : violations) {
                validationMessages.add(violation.getInvalidValue() + ": " + violation.getMessage());
            }

            if (!validationMessages.isEmpty()) {
                throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationMessages));
            }
        }

        public Athlete build() {
            Athlete athlete = new Athlete(this);
            validate(athlete);
            return athlete;
        }
    }
}