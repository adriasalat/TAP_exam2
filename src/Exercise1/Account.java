package Exercise1;

/**
 * @author Adrià Salat
 */
public class Account {
    private String id;
    private String name;
    private AccType type;
    private double balance;

    public Account(String id, String name, String type, double balance) {
        this.id = id;
        this.name = name;
        //this.type = type;
        this.balance = balance;

        switch (type){
            case "IF":this.type = AccType.IF;break;
            case "CA":this.type = AccType.CA;break;
            case "SA":this.type = AccType.SA;break;
            case "BA":this.type = AccType.BA;
        }
    }

    public String getId() { return id; }
    public double getBalance() { return balance; }
    public AccType getType() { return type; }
    public String getName() { return name; }

    public void deposit(double money){
        balance = balance + money;
    }

    @Override
    public String toString() {
        return "Account -> name: " + name + ", type: " + type + ", balance: " + balance + "\n";
    }
}
