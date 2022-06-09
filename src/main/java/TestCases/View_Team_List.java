package TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.Team_List_Page;
import PageObjects.Players_List_Page;

public class View_Team_List extends BaseClass {
	
	@Test(priority=1)
	public void Print_Team_List() {
		teamlist.Click_On_TeamList_Page();
		teamlist.Print_List_of_Teams();
	}
	
	@Test(priority=1)
	public void Search_Existng_Team() {
		System.out.println("Test Case 'Search_Existng_Team' Started");
		teamlist.Click_On_TeamList_Page();
		teamlist.Search_Team("Sweden");
		System.out.println("Test Case 'Search_Existng_Team' Completed");
		System.out.println();
		
	}
	
	@Test(priority=2)
	public void Add_Team_Verfy_Increase_Count_In_Team_List() {
		System.out.println("Test Case 'Add_Team_Verfy_Increase_Count_In_Team_List' Started");
		teamlist.Click_On_TeamList_Page();
		int team_count_before=teamlist.Print_Number_of_Teams();
		teamlist.Enter_Team_Name("Belgium");
		teamlist.Click_on_Add_Team("Belgium");
		teamlist.Click_On_Home();
		teamlist.Click_On_TeamList_Page();
		int team_count_after=teamlist.Print_Number_of_Teams();
		Assert.assertEquals(team_count_before+1, team_count_after);
		System.out.println("Test Case 'Add_Team_Verfy_Increase_Count_In_Team_List' Completed");
		System.out.println();
	}
	
	@Test(priority=2)
	public void View_Team_List_After_Add__New_Team() {
		System.out.println("Test Case 'View_Team_List_After_Add__New_Team' Started");
		teamlist.Click_On_TeamList_Page();
		teamlist.Print_List_of_Teams();
		teamlist.Enter_Team_Name("Austria");
		teamlist.Click_on_Add_Team("Austria");
		teamlist.Click_On_Home();
		teamlist.Click_On_TeamList_Page();
		teamlist.Print_List_of_Teams();
		teamlist.Search_Team("Austria");
		System.out.println("Test Case 'View_Team_List_After_Add__New_Team' Completed");
		System.out.println();

	}
	
		
}
