package Exercise2;

import java.util.LinkedList;
import java.util.List;

public class PackageDecorator extends Package {
    private Package client;
    private List<Observer<Package, PackageState>> listObservers;

    public PackageDecorator(Package pkg) {
        this.client = pkg;
        listObservers = new LinkedList<>();
    }

    @Override
    public PackageState getState() {
        return client.getState();
    }

    @Override
    public void setState(PackageState state) {
        client.setState(state);
        notifyAllObservers(client.getState());
    }

    @Override
    public void previousState() {
        client.previousState();
        notifyAllObservers(client.getState());
    }

    @Override
    public void nextState() {
        client.nextState();
        notifyAllObservers(client.getState());
    }

    @Override
    public void printStatus() {
        client.printStatus();
    }

    public void attach(Observer<Package, PackageState> obs) {
        listObservers.add(obs);
    }

    public void remove(Observer<Package, PackageState> obs) {
        listObservers.remove(obs);
    }

    public void notifyAllObservers(PackageState nextState) {
        for (Observer<Package, PackageState> o : listObservers) {
            o.update(client, nextState);
        }
    }
}
