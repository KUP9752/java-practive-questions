package ComparingPeople0378;

public class TwoTieredComparator implements PersonComparator{


    final PersonComparator first;
    final PersonComparator second;

    public TwoTieredComparator(PersonComparator first, PersonComparator second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Person p1, Person p2) {
        int comp = first.compare(p1, p2);
        if (comp == 0) comp = second.compare(p1, p2);
        return comp;
    }

    @Override
    public int compare(Person p1, Person p2) {
        int comp = first.compare(p1, p2);
        if (comp == 0) comp = second.compare(p1, p2);
        return comp;
    }
}
