import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/darshini_db";
        String user = "root";
        String password = "@b!$#3k@2003";
        Scanner sc = new Scanner(System.in);

System.out.println("===== Expense Tracker =====");
System.out.println("1. Add Expense");
System.out.println("2. View Expenses");
System.out.println("3. Exit"); 
System.out.print("Enter your choice: ");

int choice = sc.nextInt();

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

           if (choice == 1) {

    sc.nextLine();

    System.out.print("Enter Title: ");
    String title = sc.nextLine();

    System.out.print("Enter Amount: ");
    double amount = sc.nextDouble();
    sc.nextLine();

    System.out.print("Enter Category: ");
    String category = sc.nextLine();

    System.out.print("Enter Date (YYYY-MM-DD): ");
    String date = sc.nextLine();

    String sql = "INSERT INTO expenses(title, amount, category, expense_date) VALUES ('"
            + title + "', "
            + amount + ", '"
            + category + "', '"
            + date + "')";

    stmt.executeUpdate(sql);

    System.out.println("✅ Expense Added Successfully!");

} else if (choice == 2) {

    ResultSet rs = stmt.executeQuery("SELECT * FROM expenses");

    System.out.println("\n===== Expense List =====");

    while (rs.next()) {

        System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("title") + " | ₹" +
                rs.getDouble("amount") + " | " +
                rs.getString("category") + " | " +
                rs.getDate("expense_date"));
    }

} else if (choice == 3) {

    System.out.println("Thank you!");

} else {

    System.out.println("Invalid Option!");

}
con.close();

} catch (Exception e) {
    e.printStackTrace();
}

sc.close();

}
}
        

            