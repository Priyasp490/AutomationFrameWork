package DDT;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class FetchingDataFromDatabase {

	public static void main(String[] args) throws Throwable
	{
		//Step1: Register/Load mysql database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step2: get connection to database
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
		
		//Step3: Create SQL Statement
		Statement state=conn.createStatement();
		String Query="select*from students";
		
		//Step4: Execute statement/Query
		ResultSet result=state.executeQuery(Query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		
		//Step5: Close the connection
		conn.close();
		
		
	}
	
	
}
