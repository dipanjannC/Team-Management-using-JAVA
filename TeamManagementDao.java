import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TeamManagementDao {

//                                                   INSERTING THE DETAILS
	
	public int insertTeamData(TeamManagementPojo teamPojo) {
		Connection connect = DBUtil.makeConnection();
		ResultSet resultSet;
		int num = 0;
		try {
			Statement statement = connect.createStatement();
			statement.executeUpdate("insert into team(player_name,player_skill,player_country) values ('"
							+ teamPojo.getPlayerName()
							+ "','"
							+ teamPojo.getPlayerSkill()
							+ "','"
							+ teamPojo.getPlayerCountry() + "')");
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				num = resultSet.getInt(1);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
//                                                    UPDATING THE DETAILS
	
	public void updateTeamData(int number, String skill) {
		Connection connection = DBUtil.makeConnection();

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update team set player_skill='" + skill
					+ "'where jersey_number='" + number + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//                                                    REMOVING THE DETAILS
	
	public boolean removeTeamData(int number) {
		Connection connection = DBUtil.makeConnection();
		int num;
		boolean flag = false;

		try {
			Statement statement = connection.createStatement();
			num = statement
					.executeUpdate("delete from team  where jersey_number='"
							+ number + "'");
			if (num == 1) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

//                                                   LISTING THE DETAILS
	
	static ArrayList listTeamDetail() {
		Connection connection = DBUtil.makeConnection();

		ArrayList teamList = new ArrayList();

		try {
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("select * from team");

			while (resultSet.next()) {
				int number = resultSet.getInt(1);
				TeamManagementPojo pojo = new TeamManagementPojo();
				pojo.setJerseyNumber(number);
				String name = resultSet.getString(2);
				String skill = resultSet.getString(3);
				String country = resultSet.getString(4);

				pojo.setPlayerName(name);
				pojo.setPlayerSkill(skill);
				pojo.setPlayerCountry(country);

				teamList.add(pojo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teamList;
	}

//                                                  LISTING THE DETAILS BASED ON CRITERIA
	
	public ArrayList teamDetail(String criteria) {
		Connection connection = DBUtil.makeConnection();
		ArrayList teamList = new ArrayList();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select * from team order by "
							+ criteria + "");

			while (resultSet.next()) {
				int number = resultSet.getInt(1);
				TeamManagementPojo pojo = new TeamManagementPojo();
				pojo.setJerseyNumber(number);
				String name = resultSet.getString(2);
				String skill = resultSet.getString(3);
				String country = resultSet.getString(4);

				pojo.setPlayerName(name);
				pojo.setPlayerSkill(skill);
				pojo.setPlayerCountry(country);

				teamList.add(pojo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teamList;
	}

	
	 
//                                                    LISTING THE DETAILS BASED ON SKILL
	
	public static ArrayList listSkill(String skillSet) {
		Connection connection = DBUtil.makeConnection();
		ArrayList teamList = new ArrayList();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select * from team where player_skill='"
							+ skillSet + "'");
			while (resultSet.next()) {
				
				TeamManagementPojo pojo = new TeamManagementPojo();
				
				int number = resultSet.getInt(1);
				pojo.setJerseyNumber(number);
				
				String name = resultSet.getString(2);
				String skill = resultSet.getString(3);
				String country = resultSet.getString(4);

				pojo.setPlayerName(name);
				pojo.setPlayerSkill(skill);
				pojo.setPlayerCountry(country);

				teamList.add(pojo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teamList;
	}
    
//                                                 CHECKING WHETHER THE GIVEN INPUT IS IN THE DATABASE                   
	
	public boolean checkJerseyNumber(int jerseyNumber)
	{
		Connection connection = DBUtil.makeConnection();
		boolean flag=false;

		try
		{
			Statement statement = connection.createStatement();
			 ResultSet resultSet = statement.executeQuery("select * from team where jersey_number='"+jerseyNumber+"'");
			if(resultSet.next())
				flag=true;
			else
				flag=false;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
//                                                 DISPLAYING THE DETAILS
	
	public static ArrayList displayPlayer(int jerseyNumber)
	{
		Connection connection = DBUtil.makeConnection();
		ArrayList teamList = new ArrayList();
		Statement statement;

		try {
			statement = connection.createStatement();
		
			ResultSet resultSet = statement.executeQuery("select * from team where jersey_number='"+jerseyNumber+"'");

			if(resultSet.next())
			{
				TeamManagementPojo pojo = new TeamManagementPojo();
				int number = resultSet.getInt(1);
				pojo.setJerseyNumber(number);
				
				String name = resultSet.getString(2);
				String skill = resultSet.getString(3);
				String country = resultSet.getString(4);

				pojo.setPlayerName(name);
				pojo.setPlayerSkill(skill);
				pojo.setPlayerCountry(country);
				teamList.add(pojo);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			return teamList;
	}
//											DISPLAYING THE DETAILS
	
	public boolean checkCountry(String country)
    {
          Connection connection = DBUtil.makeConnection();
          boolean flag=false;
          try
          {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from team where player_country='"+country+"'");
                if(resultSet.next())
                      flag=true;
                else
                      flag=false;
          }
          catch (SQLException e) {
                e.printStackTrace();
          }
          return flag;
    }
//										LISTING THE DETAILS BASED ON COUNTRY
	
public ArrayList listPlayerByCountry(String country)
    {
          Connection connection = DBUtil.makeConnection();

          ArrayList teamList = new ArrayList();

          try {
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("select * from team where player_country='"+country+"'");

                TeamManagementPojo pojo = new TeamManagementPojo();
                
                while (resultSet.next()) {
                      
                      int number = resultSet.getInt(1);
                      pojo.setJerseyNumber(number);
                      String name = resultSet.getString(2);
                      String skill = resultSet.getString(3);
                      String playerCountry = resultSet.getString(4);

                      pojo.setPlayerName(name);
                      pojo.setPlayerSkill(skill);
                      pojo.setPlayerCountry(playerCountry);

                      teamList.add(pojo);

                }
          } catch (SQLException e) {
                e.printStackTrace();
          }
          return teamList;
    }


}
