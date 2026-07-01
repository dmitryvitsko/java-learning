public class Expense {

    // величина траты
    private double value;

    // номер транзакции
    private int transaction;

    public double getValue() {
        return value;
    }

    public void setValue(double val) {
        value = val;
    }

    public Integer getTransaction() {
        return transaction;
    }

    public void setTransaction(Integer tr) {
        transaction = tr;
    }

    public Expense(double val) {
        value = val;
        transaction = (int) Math.round(Math.random() * 1_000_000);
    }

}