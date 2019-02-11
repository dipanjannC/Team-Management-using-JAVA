import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
//										           MENU DRIVEN PROGRAM
		
		while (1 != 0) {
			System.out.println("\n\n\t----------------------------------  WELCOME TO TEAM MANAGEMENT --------------------------------");
			System.out.println("\n\n\t1.Add a Player");
			System.out.println("\n\t2.Update a Player");
			System.out.println("\n\t3.Remove a Player");
			System.out.println("\n\t4.List all Players");
			System.out.println("\n\t5.Sorting all Players based on selected Critera");
			System.out.println("\n\t6.Listing all Players based on selected Skill");
			System.out.println("\n\t7.List all Players based on Country");
			System.out.println("\n\t8.Exit");
			System.out.println("\n\n\t----------------------------------------------------------------------------------------------------");

			System.out.println("\n\n Enter your choice from 1 to 7:");

			String value = input.nextLine();
			if (checkValidation.checkDigit(value)) {
				int choice = Integer.parseInt(value);
				TeamManagementDao teamObject = new TeamManagementDao();
				switch (choice) {
				
//                                                     INSERTING THE DETAILS
				
				case 1: {

					TeamManagementPojo teamPojo = new TeamManagementPojo();
					System.out.println("Enter Player Name : ");
					String name = input.nextLine();
					name=formatStrings(name);

					if (checkValidation.checkCharacter(name) == true) {
						teamPojo.setPlayerName(name);
					} else {
						System.out.println("Invalid Input");
						break;
					}
					
					
					System.out.println("Enter Player Skill : ");
					String skill = input.nextLine();
					skill=formatStrings(skill);
					
					
					if (checkValidation.checkCharacter(skill) == true
							&& skill.length() <= 50) {
						teamPojo.setPlayerSkill(skill);
					} else {
						System.out.println("Invalid Input");
						break;
					}

					System.out.println("Enter Player Country : ");
					String country = input.nextLine();
					country=formatStrings(country);
					
					
					if (checkValidation.checkCharacter(country) == true
							&& country.length() <= 50) {
						teamPojo.setPlayerCountry(country);
					} else {
						System.out.println("Invalid Input");
						break;
					}

					int num = teamObject.insertTeamData(teamPojo);
					System.out.println("\nPlayer Details added successfully");
					System.out.println("\n\n\n");
					
					displayPlayerDetails(num);
					


					break;
				}
				
//                                                       UPDATING THE DETAILS 

				case 2: {
					System.out.println("Enter Jersey Number : ");
					String check = input.nextLine();

					if (checkValidation.checkDigit(check) == true) {
						int number = Integer.parseInt(check);
						boolean num = teamObject.checkJerseyNumber(number);

						if (num == true) {
							System.out.println("Enter Player Skill you want to update: ");
							String skill = input.nextLine();

							if (checkValidation.checkCharacter(skill) == true) {
								teamObject.updateTeamData(number, skill);
								System.out.println("Player Skill Updated Successfully");
								displayPlayerDetails(number);
							} else {
								System.out.println("Invalid Input");
								break;
							}
						}

						else {
							System.out.println("Invalid Jersey Number");
						}
					} else {
						System.out.println("Invalid Input");
					}

					break;
				}
				
//                                                       REMOVING THE DETAILS 

				case 3: {
					System.out.println("Enter Jersey Number to remove: ");
					String check = input.nextLine();

					if (checkValidation.checkDigit(check) == true) {
						int number = Integer.parseInt(check);
						boolean flag = teamObject.removeTeamData(number);

						if (flag == true) {
							System.out.println("Detail deleted Successfully");
						} else {
							System.out.println("Invalid Jersey Number");
						}
						break;
					} else {
						System.out.println("Invalid Input");
						break;
					}
				}
				
//                                                       LISTING THE DETAILS
				
				case 4: {
					ArrayList list = TeamManagementDao.listTeamDetail();
					Iterator itrTeam = list.iterator();

					System.out.print("Jersey Number \t\t      Name \t\t\t Skill \t\t\t Country\n");
					System.out.println("--------------------------------------------------------------------------------------");

					while (itrTeam.hasNext()) {

						TeamManagementPojo pojo = (TeamManagementPojo) itrTeam.next();

						System.out.println(pojo.getJerseyNumber()
								+ "\t\t\t      " + pojo.getPlayerName()
								+ "\t\t\t" + pojo.getPlayerSkill() + "\t\t\t"
								+ pojo.getPlayerCountry());
					}

					System.out.println("\n\n\t\tDetails listed Successfully");
					break;
				}
				
//                                                      LISTING THE DETAILS BASED ON CRITERIA
				
				case 5: {
					String criteria = getCriteria();

					if (criteria == "INVALID INPUT") {
						System.out.println("\t\tINVALID INPUT");
					} else {
						ArrayList list = teamObject.teamDetail(criteria);
						Iterator itrTeam = list.iterator();

						System.out.print("Jersey Number \t\t Name \t\t\t Skill \t\t\t Country\n");
						System.out.println("-----------------------------------------------------------------------------------");

						while (itrTeam.hasNext()) {
							TeamManagementPojo pojo = (TeamManagementPojo) itrTeam.next();

							System.out.println(pojo.getJerseyNumber()
									+ "\t\t\t" + pojo.getPlayerName()
									+ "\t\t\t" + pojo.getPlayerSkill()
									+ "\t\t\t" + pojo.getPlayerCountry());
						}

					}

					break;
				}

//                                                       LISTING THE DETAILS BASED ON SKILL
				
				case 6: {
					String skill = getSkill();

					if (skill == "INVALID INPUT") {
						System.out.println("\t\tINVALID INPUT");

					} else {
						ArrayList list = TeamManagementDao.listSkill(skill);
						Iterator itrTeam = list.iterator();
						System.out.print("Jersey Number \t\t Name \t\t\t Skill \t\t\t Country\n");
						System.out.println("-----------------------------------------------------------------------------------");

						while (itrTeam.hasNext()) {
							TeamManagementPojo pojo = (TeamManagementPojo) itrTeam.next();

							System.out.println(pojo.getJerseyNumber()
									+ "\t\t\t" + pojo.getPlayerName()
									+ "\t\t\t" + pojo.getPlayerSkill()
									+ "\t\t\t" + pojo.getPlayerCountry());
						}

					}
					break;
				}

//										LISTING THE DETAILS BASED ON COUNTRY			
				case 7: {
                    System.out.println("Enter the Country Name: ");
                    String country = input.nextLine();
                    if (checkValidation.checkCharacter(country) == true
                                && country.length() <= 50)
                    {
                          if(teamObject.checkCountry(country))
                          {
                                ArrayList list = teamObject.listPlayerByCountry(country);
                                Iterator itrTeam = list.iterator();

                                System.out
                                            .print("\t\tJersey Number \t\t Name \t\t\t Skill \t\t\t Country\n");
                                System.out
                                            .println("\t---------------------------------------------------------------------------------------------------");
                                while (itrTeam.hasNext()) {
                                      TeamManagementPojo pojo = (TeamManagementPojo) itrTeam
                                                  .next();

                                      System.out.println("\t\t"+pojo.getJerseyNumber()
                                                  + "\t\t\t" + pojo.getPlayerName()
                                                  + "\t\t\t" + pojo.getPlayerSkill()
                                                  + "\t\t\t" + pojo.getPlayerCountry());
                                }
                          }
                          else
                          {
                                System.out.println("No player's are there from this Country");
                          }
              }
                    else{
                          System.out.println("Invalid Input");
                    }
                    break;
              }


//                                                    CLOSING THE CONNECTION 
				
				case 8: {
					System.out.println("\n\n\t----------------------------------  THANK YOU --------------------------------");
					DBUtil.closeConnection();
					System.exit(0);
				}

				default:
					System.out.println("Invalid Input.....");
				}
			}

			else {
				System.out.println("Invalid Input");
			}
		}

	}
	
//                                                        GETTING THE CRITERIA
	
	public static String getCriteria() {
		// Scanner input = new Scanner(System.in);
		System.out.println("\t\tEnter the Critera by which you want to Sort: ");
		System.out.println("\t\tName-- 1\n\t\tSkill-- 2\n\t\tCountry-- 3");
		String s = null;

		String option = input.nextLine();

		if (checkValidation.checkDigit(option) == true) {
			int number1 = Integer.parseInt(option);

			switch (number1) {
			case 1: {
				s = "player_name";
				// input.close();
				break;
			}
			case 2: {
				s = "player_skill";
				// input.close();
				break;
			}
			case 3: {
				s = "player_country";
				// input.close();
				break;
			}
			default: {
				s = "INVALID INPUT";
				// input.close();
				break;
			}
			}
		} else {
			System.out.println("Invalid Input");
		}
		// input.close();
		return s;

	}
	
	
//                                                     GETTING THE SKILL	
	

	public static String getSkill() {
		
		String s = null;
		
		System.out.println("\t\tEnter the Skill by which you want to view: ");
		System.out.println("\t\tBatsman-- 1\n\t\tWK-Batsman-- 2\n\t\tBowler-- 3\n\t\tAll Rounder-- 4");
		String option = input.nextLine();
		
		if (checkValidation.checkDigit(option) == true) {
		
			int number1 = Integer.parseInt(option);

			switch (number1) {
			case 1: {
				s = "Batsman";
				// input.close();
				break;
			}
			case 2: {
				s = "WK-Batsman";
				// input.close();
				break;
			}
			case 3: {
				s = "Bowler";
				// input.close();
				break;
			}
			case 4: {
				s = "All Rounder";
				// input.close();
				break;
			}
			default: {
				s = "INVALID INPUT";
				// input.close();
				break;
			}
			}
		} else {
			System.out.println("Invalid Input");
		}
		// input.close();
		return s;

	}

//  							 				  FORMATTING THE STRING
	
	
	public static String formatStrings(String name) {
		String names="";

		if(name.contains(" "))
		{
		 names = name.trim().replaceAll(" +", " ");
		 names = names.toUpperCase();
		}
		else 
		{
			names=name.toUpperCase();
		}
		
		return names;
	}

// 						       					   DISPLAYING THE DETAILS

	public static void displayPlayerDetails(int jerseyNumber)
	{
		ArrayList list = TeamManagementDao.displayPlayer(jerseyNumber);
		Iterator itrTeam = list.iterator();

		System.out.print("Jersey Number \t\t      Name \t\t\t Skill \t\t\t Country\n");
		System.out.println("--------------------------------------------------------------------------------------");
		while (itrTeam.hasNext()) {

			TeamManagementPojo pojo = (TeamManagementPojo) itrTeam.next();

			System.out.println(pojo.getJerseyNumber()
					+ "\t\t\t      " + pojo.getPlayerName()
					+ "\t\t\t" + pojo.getPlayerSkill() + "\t\t\t"
					+ pojo.getPlayerCountry());
		}
	}

}
