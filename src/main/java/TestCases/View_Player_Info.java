package TestCases;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.Team_List_Page;
import PageObjects.Players_List_Page;

public class View_Player_Info extends BaseClass {
	
	@Test(priority=1)
	public void View_Existing_Player_Info() {
		System.out.println("Test Case 'View_Existing_Player_Info' Started");
		playerlist.Click_On_PlayersList_Page();
		playerlist.Search_Player("Melvin");
		playerlist.View_Player_Details("Melvin");
		System.out.println("Test Case 'View_Existing_Player_Info' Completed");
		System.out.println();
	}
	
	@Test(priority=1)
	public void Add_New_Player_View_Info() {
		System.out.println("Test Case 'Add_New_Player_View_Info' Started");
		playerlist.Click_On_PlayersList_Page();
		playerlist.Enter_Player_Name("Mpabbe");
		playerlist.Select_Country("Spain");
		playerlist.Add_Player("Mpabbe");
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Search_Player("Mpabbe");
		playerlist.View_Player_Details("Mpabbe");
		System.out.println("Test Case 'Add_New_Player_View_Info' Completed");
		System.out.println();
	}
	
	@Test(priority=2)
	public void Players_With_Same_Name_View_Info() {
		System.out.println("Test Case 'Players_With_Same_Name_View_Info' Started");
		playerlist.Click_On_PlayersList_Page();
		playerlist.Enter_Player_Name("pele");
		playerlist.Select_Country("Italy");
		playerlist.Add_Player("pele");
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Search_Player("pele");
		playerlist.Enter_Player_Name("pele");
		playerlist.Select_Country("Russia");
		playerlist.Add_Player("pele");
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Search_Player("pele");
		playerlist.View_Player_Details("pele");
		System.out.println("Test Case 'Players_With_Same_Name_View_Info' Completed");
		System.out.println();
	}
	
	

}
