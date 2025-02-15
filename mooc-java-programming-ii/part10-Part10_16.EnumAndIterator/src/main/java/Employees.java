
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Employees {

    private List<Person> people;

    public Employees() {
        this.people = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.people.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        this.people.addAll(peopleToAdd);
    }

    public void print() {
        Iterator<Person> it = this.people.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void print(Education education) {
        Iterator<Person> it = this.people.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            if (p.getEducation() == education) {
                System.out.println(p);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> it = this.people.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            if (p.getEducation() == education) {
                it.remove();
            }
        }
    }
}
