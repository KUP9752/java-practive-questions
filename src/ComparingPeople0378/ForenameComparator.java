package ComparingPeople0378;

public class ForenameComparator implements PersonComparator{
    @Override
    public int compareTo(Person p1, Person p2) {
        return p1.getForename().compareTo(p2.getForename());
    }

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getForename().compareTo(p2.getForename());
    }
}
