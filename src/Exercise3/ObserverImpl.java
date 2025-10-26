package Exercise3;

public class ObserverImpl implements Observer<Package, PackageState> {
    @Override
    public void update(Package self, PackageState newState) {
        System.out.println("Package -> " + self + " // New state -> " + newState);
    }
}
 