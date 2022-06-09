package TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.Team_List_Page;
import PageObjects.Players_List_Page;

public class Add_New_Team extends BaseClass {
	
	
	@Test(priority=1)
	public void Add_New_Team() {
		System.out.println("Test Case 'Add_New_Team' Started");
		teamlist.Click_On_TeamList_Page();
		teamlist.Enter_Team_Name("Netherlands");
		teamlist.Click_on_Add_Team("Netherlands");
		teamlist.Click_On_Home();
		teamlist.Click_On_TeamList_Page();
		teamlist.Search_Team("Netherlands");
		System.out.println("Test Case 'Add_New_Team' Completed");
		System.out.println();
	}
	
	
	@Test(priority=2)
	public void Add_Existing_Team() {
		System.out.println("Test Case 'Add_Existing_Team' Started");
		teamlist.Click_On_TeamList_Page();
		teamlist.Enter_Team_Name("Sweden");
		teamlist.Click_on_Add_for_Existing_Team("Sweden");
		System.out.println("Test Case 'Add_Existing_Team' Completed");
		System.out.println();
	}

}



