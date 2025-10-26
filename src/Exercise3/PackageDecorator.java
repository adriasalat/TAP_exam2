package Exercise3;

import java.util.ArrayList;
import java.util.List;

public class PackageDecorator extends Package {
    private Package client;
    private List<Observer<Package, PackageState>> listObservers;

    public PackageDecorator(Package pkg) {
        this.client = pkg;
        listObservers = new ArrayList<>();
    }

    @Override
    public PackageState getState() {
        return client.getState();
    }

    @Override
    public void setState(PackageState state) {
        client.setState(state);
        notifyAllObservers();
    }

    @Override
    public void previousState() {
        client.previousState();
        notifyAllObservers();
    }

    @Override
    public void nextState() {
        client.nextState();
        notifyAllObservers();
    }

    @Override
    public void printStatus() {
        client.printStatus();
    }

    public void attach(Observer<Package, PackageState> observer) {
        listObservers.add(observer);
    }

    public void remove(Observer<Package, PackageState> observer) {
        listObservers.remove(observer);
    }

    public void notifyAllObservers() {
        for (Observer<Package, PackageState> o : listObservers) {
            o.update(client, client.getState());
        }
    }
}
