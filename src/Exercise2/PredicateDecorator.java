package Exercise2;

import java.util.function.Predicate;

/**
 * @author Adrià Salat
 * Solution for the exercise 2.b
 */
public class PredicateDecorator<T> implements Predicate<T> {
    private int counter;
    private Predicate<T> client;

    public PredicateDecorator(Predicate<T> pred) {
        this.client = pred;
        counter = 0;
    }

    @Override
    public boolean test(T thing) {
        counter++;
        return client.test(thing);
    }

    public int getCountTest() { return counter; }
}
