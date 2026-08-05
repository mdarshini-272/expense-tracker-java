public class Expense {

    private int id;
    private String title;
    private double amount;
    private String category;
    private String expenseDate;

    public Expense(int id, String title, double amount, String category, String expenseDate) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.expenseDate = expenseDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getExpenseDate() {
        return expenseDate;
    }
}