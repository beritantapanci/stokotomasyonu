package Util;
import java.sql.*;



public class VeriTabaniUtil {
static Connection conn=null;
static final String DATABASE_URL="jdbc:mysql://localhost/kirtasiyeotomasyonu_db";
static final String DATABASE_USERNAME="root";
static final String DATABASE_PASSWORD="";
public static Connection Baglan() {
	
	
	
	try {
		 //Class.forName("com.mysql.cj.jdbc.Driver");
	
		conn=DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
		return conn;
		
	}
	catch (Exception e) {
	System.out.println(e.getMessage().toString());
	return null;

	}

}

}

