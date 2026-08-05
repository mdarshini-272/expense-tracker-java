import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            ExpenseDAO dao = new ExpenseDAO();
            while (true) {

    System.out.println("\n===== Expense Tracker =====");
    System.out.println("1. Add Expense");
    System.out.println("2. View Expenses");
    System.out.println("3. Update Expense");
    System.out.println("4. Delete Expense");
    System.out.println("5. Search by Category");
    System.out.println("6. Total Expenses");
    System.out.println("7. Exit");
    System.out.print("Enter your choice: ");

    int choice = sc.nextInt();
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

   Expense expense = new Expense(0, title, amount, category, date);
dao.addExpense(expense);
} 
else if (choice == 2) {

    dao.viewExpenses();
}
else if (choice == 3) {

    System.out.print("Enter Expense ID to Update: ");
    int id = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter New Title: ");
    String title = sc.nextLine();

    System.out.print("Enter New Amount: ");
    double amount = sc.nextDouble();
    sc.nextLine();

    System.out.print("Enter New Category: ");
    String category = sc.nextLine();

   dao.updateExpense(id, title, amount, category);
}
else if (choice == 4) {
    System.out.print("Enter Expense ID to Delete: ");
    int id = sc.nextInt();
   dao.deleteExpense(id);
}
else if (choice == 5) {
    sc.nextLine();
    System.out.print("Enter Category: ");
    String category = sc.nextLine();
    dao.searchByCategory(category);
}
else if (choice == 6) {
    dao.showTotalExpenses();
}
else if (choice == 7) {
    System.out.println("Thank you!");
    break;
}
else {
    System.out.println("❌ Invalid choice. Please try again.");
}
}   // while ends
} catch (Exception e) {
    e.printStackTrace();
}
sc.close();
}   // main ends
}   // class ends
        

            