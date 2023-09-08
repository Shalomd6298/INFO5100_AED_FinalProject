/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Shalom Daniel <your.name at your.org>
 */
public class mysql_db_connection {
    
    
        public void db_conn(String ID, String firstName, String lastName, String usrname, String password, Integer age, String emailID, Long phNo){
    
        try{
            //open connection
            Class.forName("com.mysql.jdbc.Driver");
           
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HousingMgmtSys","root","shalomdaniel98");
           
            //for insert data into table
            // Prepare statement
            String sql = "INSERT INTO customers (ID, FirstName, LastName, Username, Password, Age, EmailID, PhoneNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);

            // Set parameters
            statement.setString(1, ID);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, usrname);
            statement.setString(5, password);
            statement.setInt(6, age);
            statement.setString(7, emailID);
            statement.setLong(8, phNo);

            // Execute statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
//                System.out.println("Customer added successfully!");
            }

            // Close resources
            statement.close();
            //close connection
            con.close();
           
           
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
          
    }
}
