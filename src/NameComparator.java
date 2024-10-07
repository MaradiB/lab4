import java.util.Comparator;

public class NameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Beer b1 = (Beer) o1;
        Beer b2 = (Beer) o2;
        return b1.getName().compareTo(b2.getName());
    }
}
