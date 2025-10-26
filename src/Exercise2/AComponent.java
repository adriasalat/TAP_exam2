package Exercise2;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Adrià Salat
 */
interface AComponent {
	void ls();
	List<String> collect();
	List<AComponent> toList();
	List<File> search(String name);
	int size();
	void setParent(AComponent parent);
	String getName();
	// Solution for the exercise 2.a
	List<File> query(Predicate<File> condition);
}
