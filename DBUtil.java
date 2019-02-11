import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
	{
		static Connection connection;
	
		static
		{
			try 
			{
				//set Driver
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		
		}
//										MAKING CONNECTION
		static Connection makeConnection()
		{
			if (connection==null)
			{
				try
				{
					//set connector according to database
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nameOfDB", "root", "root");
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			
			}
			
			return connection;
	   
		}
		
//										CLOSING CONNECTION
		static void closeConnection()
		{
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	
}
