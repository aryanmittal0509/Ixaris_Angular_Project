package TestCases;

import java.util.List;
import PageObjects.Players_List_Page;
import PageObjects.Team_List_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;


import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;



public class BaseClass {
	
	Team_List_Page teamlist;
	Players_List_Page playerlist;
	
	
	
	@BeforeTest
	public void setup() 
	{
		teamlist = new Team_List_Page();
		playerlist = new Players_List_Page();
	}
	
	
	@AfterClass
	public void tearDown()
	{
		teamlist.driver.close();
		playerlist.driver.close();
	}

}
	
	
	
	
	
	
	
	
