package Exercise2;

import java.util.Comparator;

/**
 * @author Adrià Salat
 */
public class Order implements Comparator<AComponent> {

	public int compare(AComponent arg0, AComponent arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}

}
