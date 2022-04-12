package ComparingPeople0378;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static Person findMin(Set<Person> people, PersonComparator comparator) {
        return people.stream().min(comparator).get();
    }

    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        people.add(new Person("Pekgoz", "Kagan", "123"));
        people.add(new Person("Pekgoz", "Kagan", "456"));
        people.add(new Person("Pekgoz", "Kagan", "789"));

        PersonComparator s = new SurnameComparator();
        PersonComparator f = new ForenameComparator();
        PersonComparator t = new TelNoComparator();
        PersonComparator sf = new TwoTieredComparator(s, f);
        // Three tiered comparator is just a loaded 2 tier
        System.out.println(findMin(people, new TwoTieredComparator(sf, t)));
    }
}
