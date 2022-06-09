package PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Players_List_Page {
	
	public WebDriver driver;
	NgWebDriver ngWebDriver;
	JavascriptExecutor jsDriver;
	
	
	public Players_List_Page() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		jsDriver = (JavascriptExecutor) driver;
		ngWebDriver = new NgWebDriver(jsDriver);
		driver.get("http://localhost:4200/");
		ngWebDriver.waitForAngularRequestsToFinish();
		
	}
	
	public void Click_On_Home() {		
		driver.findElement(By.xpath("(//*[text()='Home'])")).click();
		ngWebDriver.waitForAngularRequestsToFinish();

	}

	public void Click_On_PlayersList_Page() {		
		driver.findElement(By.xpath("(//*[text()='Players'])")).click();
		ngWebDriver.waitForAngularRequestsToFinish();


	}
		
	public void Enter_Player_Name(String player) {		
		driver.findElement(By.xpath("//input[@placeholder='Player Name']")).sendKeys(player);
		ngWebDriver.waitForAngularRequestsToFinish();


	}

	public void Select_Country(String Country_Name) {	
		
		WebElement Country_dropdown=driver.findElement(By.xpath("/html/body/app-root/ng-component/div/div[2]/div[2]/select"));
		
		Select country = new Select(Country_dropdown);
		
		country.selectByVisibleText("Sweden");
		country.selectByVisibleText(Country_Name);
		
		Assert.assertEquals(Country_Name, country.getFirstSelectedOption().getText());
		System.out.println(Country_Name + " is selected");

	}

	public void Add_Player(String player) {		
		driver.findElement(By.xpath("(//*[text()='Add Player'])")).click();
		System.out.println(player + " is added in Players List");
		ngWebDriver.waitForAngularRequestsToFinish();


	}
	
	public int Print_Number_of_Players() {		
		List<WebElement> rowelements = driver.findElements(By.xpath("/html/body/app-root/ng-component/div/table/tbody/tr"));
		System.out.println("No. of Players present in team list are " + rowelements.size());
		int x=rowelements.size();
		ngWebDriver.waitForAngularRequestsToFinish();
		return x;

	}
	
	public void Print_List_of_Players() {
		List<WebElement> rowelements = driver.findElements(By.xpath("/html/body/app-root/ng-component/div/table/tbody/tr"));
		int rowsize = rowelements.size();
		System.out.println("No. of Total players present in player list are " + rowsize + " which are listed below");
		
		List<WebElement> columnelements = driver.findElements(By.xpath("/html/body/app-root/ng-component/div/table/tbody/tr[1]/td"));
		int colsize = columnelements.size();
		
		for(int i=1; i<=rowsize; i++) {
			for(int j=1; j<=2; j++) {
				
				System.out.print(driver.findElement(By.xpath("/html/body/app-root/ng-component/div/table/tbody/tr["+ i +"]/td["+ j +"]")).getText()+ " ");
				System.out.print("   ");
			}
			System.out.println();
		}
		
		ngWebDriver.waitForAngularRequestsToFinish();

	}


	public void Search_Player(String player) {
		
		if(driver.findElement(By.xpath("//td[1][text()='"+player+"']")).isDisplayed()) {
			List<WebElement> rowelements = driver.findElements(By.xpath("//td[1][text()='"+player+"']"));
			int rowsize = rowelements.size();
			System.out.println("Total no. of players with name "+ player +" is/are " + rowsize);
		}
		else {
			System.out.println(player + " is not present in player list");
		}
	}


	public void Print_List_of_All_Players_inTeam(String country) {
		List<WebElement> rowelements = driver.findElements(By.xpath("//td[2][text()='"+country+"']"));
		int rowsize = rowelements.size();
		System.out.println("Total no. of players in "+ country +" are " + rowsize + " which are listed below");
		
		List<WebElement> TeamPlayers = driver.findElements(By.xpath("//td[2][text()='"+country+"']//preceding-sibling::td[1]"));
		for(WebElement ele: TeamPlayers) {
			System.out.println(ele.getText());
		}
		ngWebDriver.waitForAngularRequestsToFinish();
	}

	
	
	public void View_Player_Details(String player) {
		List<WebElement> rowelements = driver.findElements(By.xpath("//td[1][text()='"+player+"']//preceding-sibling::th[1]"));		
		int rowsize = rowelements.size();
		System.out.println("Total no. of players with name "+ player +" is/are " + rowsize + " which are listed below with all details");
		
		for(WebElement ele: rowelements) {
			System.out.print(player+ "  Team id - " +ele.getText()+ "  Country -  " +driver.findElement(By.xpath("/html/body/app-root/ng-component/div/table/tbody/tr["+ele.getText()+"]/td[2]")).getText() );
			System.out.println();	
		}
		ngWebDriver.waitForAngularRequestsToFinish();
	}

	
}
