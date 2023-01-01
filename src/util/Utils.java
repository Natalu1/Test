package util;

import java.util.Collection;

public class Utils<T> {
    public void printCollectionInColumn(Collection<T> collection) {
        for (T element : collection) {
            System.out.println(element);
        }
    }
}
