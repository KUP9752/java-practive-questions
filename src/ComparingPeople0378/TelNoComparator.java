package ComparingPeople0378;

public class TelNoComparator implements PersonComparator{
    @Override
    public int compareTo(Person p1, Person p2) {
        return p1.getTelNo().compareTo(p2.getTelNo());
    }

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getTelNo().compareTo(p2.getTelNo());
    }
}
