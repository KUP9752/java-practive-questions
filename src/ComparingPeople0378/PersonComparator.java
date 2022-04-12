package ComparingPeople0378;

import java.util.Comparator;

public interface PersonComparator extends Comparator<Person> {

    int compareTo(Person p1, Person p2);
}
