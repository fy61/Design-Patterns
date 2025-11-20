package BehavioralPatterns.IteratorPattern;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NameRepository implements Iterable<String> {
    private String[] names = {"Alice", "Bob", "Charlie"};

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            int index = 0;
            public boolean hasNext() {
                return index < names.length;
            }
            public String next() {
                if (!hasNext()) throw new NoSuchElementException();
                return names[index++];
            }
        };
    }
}
