package ComparingPeople0378;

public class SurnameComparator implements PersonComparator{

    @Override
    public int compareTo(Person p1, Person p2) {
        return p1.getSurename().compareTo(p2.getSurename());
    }

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getSurename().compareTo(p2.getSurename());
    }
}
