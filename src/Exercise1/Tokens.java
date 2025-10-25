package Exercise1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Adrià Salat
 */
public class Tokens {

    public static void main(String[] args) throws IOException {

        // Exercise 1.a
        FileReader fis = new FileReader("accounts.txt");
        BufferedReader dis = new BufferedReader(fis);
        String line;

        List<Account> list = new LinkedList<>();

        while ((line = dis.readLine()) != null) {
           StringTokenizer tokens = new StringTokenizer(line, ",");
            while (tokens.hasMoreTokens()) {
                Account c = new Account(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), Double.parseDouble(tokens.nextToken()));
                list.add(c);
            }
        }

        dis.close();

        // Prove that exercise 1.b works correctly
        Predicate<Account> condition_b = (Account a) -> a.getBalance() > 10000;
        Function<Account, String> function = Account::getName;
        System.out.println(select(list, condition_b, function));

        System.out.println("-------------------------");

        // Prove that exercise 1.c works correctly
        Predicate<Account> condition_c1 = (Account a) -> a.getBalance() > 10000;
        Predicate<Account> condition_c2 = (Account a) -> a.getType().equals(AccType.IF);
        Predicate<Account> condition_c3 = (Account a) -> a.getBalance() < 1000;
        Function<Account, Account> function_c1 = a -> a;
        Function<Account, List<Object>> function_c2 = a -> Arrays.asList(a.getName(), a.getBalance());
        Function<Account, String> function_c3 = Account::getName;
        System.out.println(genericSelect(list, condition_c1, function_c1));
        System.out.println(genericSelect(list, condition_c2, function_c2));
        System.out.println(genericSelect(list, condition_c3, function_c3));

        System.out.println("-------------------------");

        // Prove that exercise 1.d works correctly
        Predicate<Account> condition_d = (Account a) -> a.getBalance() > 10000;
        Function<Account, Double> function_d = Account::getBalance;
        Comparator<Double> orderByBalance_d = (Double b1, Double b2) -> b1.compareTo(b2);
        System.out.println(orderSelectGeneric(list, condition_d, function_d, orderByBalance_d));
    }

    // Exercise 1.b
    // SELECT name FROM Accounts WHERE balance > 10000
    public static List<String> select(List<Account> list, Predicate<Account> condition, Function<Account, String> function) {
        List<String> result = list.stream().filter(condition).map(function).toList();
        return result;
    }

    // Exercise 1.c
    // SELECT * FROM Accounts WHERE balance > 10000
    // SELECT name, balance FROM Accounts WHERE type == "IF"
    // SELECT type FROM Accounts WHERE balance < 1000
    public static <T> List<T> genericSelect(List<Account> list, Predicate<Account> condition, Function<Account, T> function) {
        List<T> result = list.stream().filter(condition).map(function).toList();
        return result;
    }

    // Exercise 1.d
    // SELECT balance FROM Accounts WHERE balance < 10000 ORDER BY balance
    public static <T> List<T> orderSelectGeneric(List<Account> list, Predicate<Account> condition, Function<Account, T> function, Comparator<T> orderBy) {
        List<T> result = list.stream().filter(condition).map(function).sorted(orderBy).toList();
        return result;
    }
}
