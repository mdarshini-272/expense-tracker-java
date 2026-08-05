import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class ExpenseDAO {

    public void addExpense(Expense expense) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO expenses(title, amount, category, expense_date) VALUES (?, ?, ?, ?)";

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setString(1, expense.getTitle());
        pstmt.setDouble(2, expense.getAmount());
        pstmt.setString(3, expense.getCategory());
        pstmt.setString(4, expense.getExpenseDate());

        pstmt.executeUpdate();

        System.out.println("✅ Expense Added Successfully!");

 con.close();
    }

public void viewExpenses() throws Exception {

    Connection con = DBConnection.getConnection();

    String sql = "SELECT * FROM expenses";

    Statement stmt = con.createStatement();

    ResultSet rs = stmt.executeQuery(sql);

    System.out.println("\n===== Expense List =====");

    while (rs.next()) {

        System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("title") + " | ₹" +
                rs.getDouble("amount") + " | " +
                rs.getString("category") + " | " +
                rs.getDate("expense_date"));
    }

    con.close();
}

public void updateExpense(int id, String title, double amount, String category) throws Exception {

    Connection con = DBConnection.getConnection();

    String sql = "UPDATE expenses SET title=?, amount=?, category=? WHERE id=?";

    PreparedStatement pstmt = con.prepareStatement(sql);

    pstmt.setString(1, title);
    pstmt.setDouble(2, amount);
    pstmt.setString(3, category);
    pstmt.setInt(4, id);

    int rows = pstmt.executeUpdate();

    if (rows > 0)
        System.out.println("✅ Expense Updated Successfully!");
    else
        System.out.println("❌ Expense ID Not Found.");

    con.close();
}

public void deleteExpense(int id) throws Exception {

    Connection con = DBConnection.getConnection();

    String sql = "DELETE FROM expenses WHERE id=?";

    PreparedStatement pstmt = con.prepareStatement(sql);

    pstmt.setInt(1, id);

    int rows = pstmt.executeUpdate();

    if (rows > 0)
        System.out.println("✅ Expense Deleted Successfully!");
    else
        System.out.println("❌ Expense ID Not Found.");

    con.close();
}
public void searchByCategory(String category) throws Exception {

    Connection con = DBConnection.getConnection();

    String sql = "SELECT * FROM expenses WHERE category=?";

    PreparedStatement pstmt = con.prepareStatement(sql);

    pstmt.setString(1, category);

    ResultSet rs = pstmt.executeQuery();

    System.out.println("\n===== Search Result =====");

    boolean found = false;

    while (rs.next()) {

        found = true;

        System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("title") + " | Rs. " +
                rs.getDouble("amount") + " | " +
                rs.getString("category") + " | " +
                rs.getDate("expense_date"));
    }

    if (!found) {
        System.out.println("No expenses found.");
    }

    con.close();
}
public void showTotalExpenses() throws Exception {

    Connection con = DBConnection.getConnection();

    String sql = "SELECT SUM(amount) AS total FROM expenses";

    PreparedStatement pstmt = con.prepareStatement(sql);

    ResultSet rs = pstmt.executeQuery();

    if (rs.next()) {
        System.out.println("\nTotal Expenses: Rs. " + rs.getDouble("total"));
    }

    con.close();
}

}