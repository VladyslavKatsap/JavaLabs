package lab1;

import java.util.Objects;

public class Competition {
    private String name;
    private int category ;

    public Competition(String name, int category) {
        this.name = name;
        this.category = category;
    }


    @Override
    public String toString() {
        return "Competition name= '" + name + "', category(kg) = " + category;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Competition subject = (Competition) obj;
        return category == subject.category && Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    public Object getName() {
        return this.name;
    }
}