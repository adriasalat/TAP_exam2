package Exercise3;

import java.lang.reflect.Proxy;

public class StateDemo {

    public static void main(String[] args) {

        PackageDecorator pkg = new PackageDecorator(new Package());
        PackageDecorator pkg2 = new PackageDecorator(new Package());

        Observer obs = (Observer) Proxy.newProxyInstance(Observer.class.getClassLoader(), 
                                                         new Class<?>[] {Observer.class},
                                                         new FileWriterDynamicProxy(new ObserverImpl(), "stateChanges.log"));
                                                
        pkg.attach(obs);
        pkg2.attach(obs);

        pkg.printStatus();
        pkg.nextState(); // Ordered -> Delievered
        pkg.printStatus();
        pkg.nextState(); // Delievered -> Recieved
        pkg.printStatus();
        
        System.out.println("\n ==================== \n");

        pkg2.setState(new DeliveredState());
        pkg2.printStatus();
        pkg2.nextState(); // Delievered -> Recieved
        pkg2.printStatus();
    }
}
