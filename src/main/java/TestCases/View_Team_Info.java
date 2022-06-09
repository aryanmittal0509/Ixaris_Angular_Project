package TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.Team_List_Page;
import PageObjects.Players_List_Page;

public class View_Team_Info extends BaseClass {
	
	@Test(priority=1)
	public void Print_List_of_All_Players_in_Team() {
		System.out.println("Test Case 'Print_List_of_All_Players_in_Team' Started");
		playerlist.Click_On_PlayersList_Page();
		playerlist.Print_List_of_All_Players_inTeam("Malta");
		System.out.println("Test Case 'Print_List_of_All_Players_in_Team' Completed");
		System.out.println();
	}
	
	@Test(priority=1)
	public void View_Team_Info() {
		System.out.println("Test Case 'View_Team_Info' Started");
		teamlist.Click_On_TeamList_Page();
		teamlist.Click_On_Teams_View("Germany");
		playerlist.Click_On_PlayersList_Page();
		playerlist.Print_List_of_All_Players_inTeam("Germany");
		System.out.println("Test Case 'View_Team_Info' Completed");
		System.out.println();
	}
	
	@Test(priority=2)
	public void Add_New_Payers_Get_Team_Info() {
		System.out.println("Test Case 'Add_New_Payers_Get_Team_Info' Started");
		teamlist.Click_On_TeamList_Page();
		teamlist.Search_Team("Italy");
		playerlist.Click_On_PlayersList_Page();
		playerlist.Enter_Player_Name("Justin");
		playerlist.Select_Country("Italy");
		playerlist.Add_Player("Justin");
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Enter_Player_Name("Langer");
		playerlist.Select_Country("Italy");
		playerlist.Add_Player("Langer");
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Print_List_of_All_Players_inTeam("Italy");
		System.out.println("Test Case 'Add_New_Payers_Get_Team_Info' Completed");
		System.out.println();

	}

}
