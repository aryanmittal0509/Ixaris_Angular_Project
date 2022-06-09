package TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.Team_List_Page;
import PageObjects.Players_List_Page;


public class Add_New_Player extends BaseClass {
	
	@Test(priority=1)
	public void Add_New_Player_Existing_Team() {
		System.out.println("Test Case 'Add_New_Player_Existing_Team' Started");
		playerlist.Click_On_PlayersList_Page();
		playerlist.Enter_Player_Name("Mesut Ozil");
		playerlist.Select_Country("Germany");
		playerlist.Add_Player("Mesut Ozil");
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Search_Player("Mesut Ozil");
		System.out.println("Test Case 'Add_New_Player_Existing_Team' Completed");
		System.out.println();
	}
	
	@Test(priority=1)
	public void Add_New_Player_New_Team() {
		System.out.println("Test Case 'Add_New_Player_New_Team' Started");
		teamlist.Click_On_TeamList_Page();
		teamlist.Enter_Team_Name("Brazil");
		teamlist.Click_on_Add_Team("Brazil");
		teamlist.Click_On_Home();
		teamlist.Click_On_TeamList_Page();
		teamlist.Click_On_Home();
		teamlist.Click_On_TeamList_Page();
		teamlist.Search_Team("Brazil");
		playerlist.Click_On_PlayersList_Page();
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Enter_Player_Name("Neymar");
		playerlist.Select_Country("Brazil");
		playerlist.Add_Player("Neymar");
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Search_Player("Neymar");
		System.out.println("Test Case 'Add_New_Player_New_Team' Completed");
		System.out.println();
	}
	
	@Test(priority=2)
	public void Add_New_Player_Same_Name() {
		System.out.println("Test Case 'Add_New_Player_Same_Name' Started");
		playerlist.Click_On_PlayersList_Page();
		playerlist.Enter_Player_Name("Zlatan");
		playerlist.Select_Country("Sweden");
		playerlist.Add_Player("Zlatan");
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Enter_Player_Name("Zlatan");
		playerlist.Select_Country("Italy");
		playerlist.Add_Player("Zlatan");
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Search_Player("Zlatan");
		System.out.println("Test Case 'Add_New_Player_Same_Name' Completed");
		System.out.println();
	}

}
