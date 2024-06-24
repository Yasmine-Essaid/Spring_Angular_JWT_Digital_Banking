package ma.emsi.ebankingbackend.exeptions;

public class BankAccountNotFoundExeption extends Exception {
    public BankAccountNotFoundExeption(String message) {
        super(message);
    }
}
