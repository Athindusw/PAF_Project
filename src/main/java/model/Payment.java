package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment {
	//A common method to connect to the DB
	private Connection connect() 
	 { 
	 Connection con = null; 
	 try
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 
	 //Provide the correct details 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3325/PAF", "root", ""); 
	 } 
	 catch (Exception e) 
	 {e.printStackTrace();} 
	 return con; 
	 } 
	public String insertPayment(String billno, String name, String amount, String contact) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for inserting."; } 
	 // create a prepared statement
	 String query = " insert into payments (`Id`,`billno`,`name`,`amount`,`contact`)"
	 + " values (?, ?, ?, ?, ?)"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, 0); 
	 preparedStmt.setString(2, billno); 
	 preparedStmt.setString(3, name); 
	 preparedStmt.setDouble(4, Double.parseDouble(amount)); 
	 preparedStmt.setString(5, contact); 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Inserted successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while inserting the payment."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	public String readPayments() 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for reading."; } 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>Bill No</th><th>Customer Name</th>" +
	 "<th>Bill Amount</th>" + 
	 "<th>Customer Contact</th>" +
	 "<th>Update</th><th>Remove</th></tr>"; 
	 
	 String query = "select * from payments"; 
	 Statement stmt = con.createStatement(); 
	 ResultSet rs = stmt.executeQuery(query); 
	 // iterate through the rows in the result set
	 while (rs.next()) 
	 { 
	 String Id = Integer.toString(rs.getInt("Id")); 
	 String billno = rs.getString("billno"); 
	 String name = rs.getString("name"); 
	 String amount = Double.toString(rs.getDouble("amount")); 
	 String contact = rs.getString("contact"); 
	 // Add into the html table
	 output += "<tr><td>" + billno + "</td>"; 
	 output += "<td>" + name + "</td>"; 
	 output += "<td>" + amount + "</td>"; 
	 output += "<td>" + contact + "</td>"; 
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='payments.jsp'>"
	 + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
	 + "<input name='ID' type='hidden' value='" + Id
	 + "'>" + "</form></td></tr>"; 
	 } 
	 con.close(); 
	 // Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while reading the items."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	public String updatePayment(String Id, String billno, String name, String amount, String contact)
	{ 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for updating."; } 
		 // create a prepared statement
		 String query = "UPDATE payments SET billno=?,name=?,amount=?,contact=? WHERE Id=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setString(1, billno); 
		 preparedStmt.setString(2, name); 
		 preparedStmt.setDouble(3, Double.parseDouble(amount)); 
		 preparedStmt.setString(4, contact); 
		 preparedStmt.setInt(5, Integer.parseInt(Id)); 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Updated successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while updating"; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
		public String deletePayment(String Id) 
		 { 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for deleting."; } 
		 // create a prepared statement
		 String query = "delete from payments where Id=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(Id)); 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Deleted successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while deleting"; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
		} 



