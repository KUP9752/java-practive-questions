package ComparingPeople0378;

public class Person {

    private final String surname;
    private final String forename;
    private final String telNo;

    public Person(String surname, String forename, String telNo) {
        this.surname = surname;
        this.forename = forename;
        this.telNo = telNo;
    }

    public String getSurename() {
        return surname;
    }

    public String getForename() {
        return forename;
    }

    public String getTelNo() {
        return telNo;
    }

    @Override
    public String toString() {
        return forename + " " + surname + ", " + telNo;
    }

    public static void main(String[] args) {
        String s1 = "Kagan";
        String s2 = "Kagam";
        System.out.println(s1.compareTo(s2));
    }
}
