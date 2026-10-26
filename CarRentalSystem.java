package myproject1;

import java.sql.*;
import java.util.Scanner;

public class CarRentalSystem {

    Connection con;
    Scanner sc = new Scanner(System.in);

    // Constructor
    public CarRentalSystem() {
        con = DBConnection.getConnection();
    }

    // ✅ ADD MAIN METHOD HERE
    public static void main(String[] args) throws Exception {
        System.out.println("Running Car Rental JDBC Project...");

        CarRentalSystem system = new CarRentalSystem();
        system.menu();
    }

    public void showAvailableCars() throws Exception {
        String query = "SELECT * FROM cars WHERE is_available = 1";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("\nAvailable Cars:");
        while (rs.next()) {
            System.out.println(
                rs.getString("car_id") + " - " +
                rs.getString("brand") + " " +
                rs.getString("model") +
                " | Price/Day: " + rs.getDouble("price_per_day"));
        }
    }

    public void rentCar() throws Exception {
        showAvailableCars();

        System.out.print("\nEnter Car ID to Rent: ");
        String id = sc.nextLine();

        String q = "UPDATE cars SET is_available = 0 WHERE car_id = ?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("\nCar Rented Successfully ✔");
        else
            System.out.println("\nCar Not Available ❌");
    }

    public void returnCar() throws Exception {
        System.out.print("\nEnter Car ID to Return: ");
        String id = sc.nextLine();

        String q = "UPDATE cars SET is_available = 1 WHERE car_id = ?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("\nCar Returned Successfully ✔");
        else
            System.out.println("\nInvalid Car ID ❌");
    }

    public void menu() throws Exception {
        while (true) {
            System.out.println("\n===== Car Rental System =====");
            System.out.println("1. Rent Car");
            System.out.println("2. Return Car");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int ch = Integer.parseInt(sc.nextLine());

            if (ch == 1) rentCar();
            else if (ch == 2) returnCar();
            else if (ch == 3) break;
            else System.out.println("Invalid Choice");
        }

        System.out.println("\nThank you!");
    }
}
