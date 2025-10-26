package Exercise2;

public class StateDemo {

    public static void main(String[] args) {

        PackageDecorator pkg = new PackageDecorator(new Package());

        pkg.attach(new ObserverImpl<>());

        pkg.printStatus();
        pkg.nextState();
        pkg.printStatus();
        pkg.previousState();
        pkg.printStatus();
        pkg.nextState();
        pkg.printStatus();
        pkg.nextState();
        pkg.printStatus();
    }
}
