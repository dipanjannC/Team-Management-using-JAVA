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
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		
		}
//													MAKING CONNECTION
		static Connection makeConnection()
		{
			if (connection==null)
			{
				try
				{
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Criket_Team", "root", "root");
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			
			}
			
			return connection;
	   
		}
		
//													CLOSING CONNECTION
		static void closeConnection()
		{
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	
}