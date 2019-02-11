
public class TeamManagementPojo 
{
	
	//variable declaration
	
	private int jerseyNumber;
	private String playerName;
	private String playerSkill;
	private String playerCountry;
	
	//getter,setter for Jersey Number
	public  void setJerseyNumber(int jerseyNum)
	{
		jerseyNumber = jerseyNum;
	}
	
	public  int getJerseyNumber()
	{
		return jerseyNumber;
	}

	
	//getter,setter for Player Name
	
	public String getPlayerName() 
	{
		return playerName;
	}
	
	public void setPlayerName(String name) 
	{
		this.playerName = name;
	}
	
	//getter,setter for Player Skill
	
	public String getPlayerSkill() 
	{
		return playerSkill;
	}
	
	public void setPlayerSkill(String skill) 
	{
		this.playerSkill = skill;
	}
	
	//getter,setter for Player's Country
	
	public String getPlayerCountry() 
	{
		return playerCountry;
	}
	public void setPlayerCountry(String country) 
	{
		this.playerCountry = country;
	}
	
}

