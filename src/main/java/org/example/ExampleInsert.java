package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.example.SqlQuery.GetEmployeeByOfficeCode;


public class ExampleInsert {

    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        final String USER = "root";
        final String PASS = "rootpwd61#";
        Connection conn = DriverManager.getConnection(url, USER, PASS);

        String sqlQuery = "INSERT INTO employees (officeCode,firstName,lastName,email,extension,reportsTo,VacationHours,employeeNumber,jobTitle) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);

        prepStmt.setInt(1, 6);
        prepStmt.setString(2, "Jamil");
        prepStmt.setString(3, "fink");
        prepStmt.setString(4, "JJ@gmail.com");
        prepStmt.setString(5, "2759");
        prepStmt.setInt(6, 1143);
        prepStmt.setInt(7, 9);
        prepStmt.setInt(8, 199);
        prepStmt.setString(9, "Manager");

      //  int affectedRows = prepStmt.executeUpdate();
      //  System.out.println("affected rows=" + affectedRows);
        prepStmt.close(); // Close the prepared statement after use

        //==================================================
        // Example UPD
        //==================================================
        String SelectSQL = "update employees set firstName=? , lastName=? where employeeNumber=?";
        PreparedStatement mystmt = conn.prepareStatement(SelectSQL);
        mystmt.setString(1, "Gary");
        mystmt.setString(2, "Larson");
        mystmt.setLong  (3, 99);
        mystmt.executeUpdate();

      //  affectedRows = mystmt.executeUpdate();
      //  System.out.println("UPD affected rows=" + affectedRows);
        mystmt.close(); // Close the prepared statement after use

        //=============================================
        // Use SqlQuery class
        //=============================================


        PreparedStatement myStmt = conn.prepareStatement(GetEmployeeByOfficeCode);
        myStmt.setDouble(1, 1);


        ResultSet result = myStmt.executeQuery();
        while(result.next())
        {
            String EmployeeID  = result.getString("employeeNumber");
            String fname = result.getString("firstName");
            String lname  = result.getString("lastName");
            String oc = result.getString("officeCode");
            System.out.println(EmployeeID +" | " + fname + "|"+ lname + "|"+ oc);
        }
        conn.close();
    }
}