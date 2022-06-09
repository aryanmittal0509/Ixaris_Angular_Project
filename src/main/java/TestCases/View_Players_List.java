package TestCases;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.Team_List_Page;
import PageObjects.Players_List_Page;

public class View_Players_List extends BaseClass {
	
	@Test(priority=1)
	public void View_Players_List() {
		playerlist.Click_On_PlayersList_Page();
		playerlist.Print_List_of_Players();
	}
	
	@Test(priority=2)
	public void Add_Player_Verfy_Increase_Count_In_Player_List() {
		System.out.println("Test Case 'Add_Player_Verfy_Increase_Count_In_Player_List' Started");
		playerlist.Click_On_PlayersList_Page();
		int player_count_before=playerlist.Print_Number_of_Players();
		playerlist.Enter_Player_Name("Zack");
		playerlist.Select_Country("Malta");
		playerlist.Add_Player("Zack");
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		int player_count_after=playerlist.Print_Number_of_Players();
		Assert.assertEquals(player_count_before+1, player_count_after);
		System.out.println("Test Case 'Add_Player_Verfy_Increase_Count_In_Player_List' Completed");
		System.out.println();
	}
	
	@Test(priority=2)
	public void View_Player_List_After_Add__New_Player() {
		System.out.println("Test Case 'View_Player_List_After_Add__New_Player' Started");
		playerlist.Click_On_PlayersList_Page();
		playerlist.Print_List_of_Players();
		playerlist.Enter_Player_Name("Sergei");
		playerlist.Select_Country("Russia");
		playerlist.Add_Player("Sergei");
		playerlist.Click_On_Home();
		playerlist.Click_On_PlayersList_Page();
		playerlist.Print_List_of_Players();
		playerlist.Search_Player("Sergei");
		System.out.println("Test Case 'View_Player_List_After_Add__New_Player' Completed");
		System.out.println();

	}
	

}
