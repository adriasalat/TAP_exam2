package Exercise2;

import java.util.function.Predicate;

/**
 * @author Adrià Salat
 */
public class Main {

	public static void main(String[] args) throws ExistException{
		Directory root = new Directory("root");
		Directory home = new Directory("home");
		Directory lp = new Directory("lp");
		File f1 = new File("f1",1234);
		File f2 = new File("f2",3445);
		File f3 = new File("f3",6688);
		File f4 = new File("f4",99999);
		// root have files f1, f2, f3
		root.addChild(f1);
		root.addChild(f2);
		root.addChild(home);
		// home have file f3
		home.addChild(f3);
		// lp have all files
		lp.addChild(f4);
		lp.addChild(root);

		// Prove that exercise 2.a works correctly
		Predicate<File> condition = (File f) -> f.getSize() > 5000;

		System.out.println("FOR FILE: " + f1.query(condition));
		System.out.println("FOR FILE: " + f4.query(condition));
		System.out.println("FOR DIRECTORY: " + root.query(condition));

		System.out.println("\n===============================\n");

		// Prove that exercise 2.b works correctly
		PredicateDecorator<File> condition2 = new PredicateDecorator<>(condition);
		System.out.println("FOR FILE: " + f1.query(condition2));
		System.out.println("COUNTER: " + condition2.getCountTest()); // It will return 1
		System.out.println("FOR FILE: " + f4.query(condition2));
		System.out.println("COUNTER: " + condition2.getCountTest()); // It will return 2
		System.out.println("FOR DIRECTORY: " + root.query(condition2));
		System.out.println("COUNTER: " + condition2.getCountTest()); // It will return 5
	}
}
