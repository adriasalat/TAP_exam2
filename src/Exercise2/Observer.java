package Exercise2;

public interface Observer<T, U> {
    void update(T self, U newState);
}
