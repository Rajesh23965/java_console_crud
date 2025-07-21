import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {
    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "NewPassword"; 

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Student CRUD Menu ---");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.next();
                        System.out.print("Enter email: ");
                        String email = sc.next();
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();

                        String insertSQL = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";
                        PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
                        insertStmt.setString(1, name);
                        insertStmt.setString(2, email);
                        insertStmt.setInt(3, age);
                        insertStmt.executeUpdate();
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        Statement selectStmt = conn.createStatement();
                        ResultSet rs = selectStmt.executeQuery("SELECT * FROM students");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                               ", Name: " + rs.getString("name") +
                                               ", Email: " + rs.getString("email") +
                                               ", Age: " + rs.getInt("age"));
                        }
                        break;

                    case 3:
                        System.out.print("Enter student ID to update: ");
                        int updateId = sc.nextInt();
                        System.out.print("Enter new name: ");
                        String newName = sc.next();
                        System.out.print("Enter new email: ");
                        String newEmail = sc.next();
                        System.out.print("Enter new age: ");
                        int newAge = sc.nextInt();

                        String updateSQL = "UPDATE students SET name=?, email=?, age=? WHERE id=?";
                        PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
                        updateStmt.setString(1, newName);
                        updateStmt.setString(2, newEmail);
                        updateStmt.setInt(3, newAge);
                        updateStmt.setInt(4, updateId);
                        updateStmt.executeUpdate();
                        System.out.println("Student updated successfully.");
                        break;

                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteSQL = "DELETE FROM students WHERE id=?";
                        PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL);
                        deleteStmt.setInt(1, deleteId);
                        deleteStmt.executeUpdate();
                        System.out.println("Student deleted successfully.");
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 5);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
