package Exercise2;

public class ObserverImpl<T, U> implements Observer<T, U> {
    public void update(T self, U newState) {
        System.out.println(self + " is gonna change the state to " + newState);
    }
}
