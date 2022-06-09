package PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Team_List_Page {
	
	public WebDriver driver;
	NgWebDriver ngWebDriver;
	JavascriptExecutor jsDriver;
	
	
	
	public Team_List_Page() 
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
	
	public void Click_On_TeamList_Page() {		
		driver.findElement(By.xpath("(//*[text()='Teams'])")).click();
		ngWebDriver.waitForAngularRequestsToFinish();



	}
	
	public void Enter_Team_Name(String country) {		
		driver.findElement(By.xpath("//input[@placeholder='Team Name']")).sendKeys(country);


	}
	
	public void Click_on_Add_for_Existing_Team(String Team) {	
		try {
		driver.findElement(By.xpath("(//*[text()='Add Team'])")).click();
		}
		finally {
			System.out.println(Team + " is already present in Teams List");
		}
		
	}
		
		public void Click_on_Add_Team(String Team) {	
			driver.findElement(By.xpath("(//*[text()='Add Team'])")).click();
			System.out.println(Team + " is added in Teams List");

	}
	
	public int Print_Number_of_Teams() {		
		List<WebElement> rowelements = driver.findElements(By.xpath("/html/body/app-root/ng-component/div/table/tbody/tr"));
		System.out.println("No. of teams present in team list are " + rowelements.size());
		int x=rowelements.size();
		ngWebDriver.waitForAngularRequestsToFinish();
		return x;

	}
	
	public void Print_List_of_Teams() {
		List<WebElement> rowelements = driver.findElements(By.xpath("/html/body/app-root/ng-component/div/table/tbody/tr"));
		int rowsize = rowelements.size();
		System.out.println("No. of teams present in team list are " + rowsize + " which are listed below");
		
		List<WebElement> columnelements = driver.findElements(By.xpath("/html/body/app-root/ng-component/div/table/tbody/tr[1]/td"));
		int colsize = columnelements.size();
		
		for(int i=1; i<=rowsize; i++) {
			for(int j=1; j<=colsize-1; j++) {
				
				System.out.print(driver.findElement(By.xpath("/html/body/app-root/ng-component/div/table/tbody/tr["+ i +"]/td["+ j +"]")).getText()+ " ");
				
			}
			System.out.println();
		}
		
		ngWebDriver.waitForAngularRequestsToFinish();

	}
	
	public void Search_Team(String country) {
		
		List<WebElement> countries = driver.findElements(By.xpath("/html/body/app-root/ng-component/div/table/tbody/tr/td[1]"));
		
		boolean status = false;
		
		for(WebElement ele: countries) {
			String value = ele.getText();
			if(value.contains(country)) {
				status=true;
				System.out.println(country + " is present in team list");
				break;
			}
		}
		Assert.assertTrue(status, country + " is not present in team list");
	}
	
	public void Click_On_Teams_View(String country) {	
		
		driver.findElement(By.xpath("//td[text()='"+country+"']//following-sibling::td[1]//a")).click();
		
	}
		
	
	public void Click_On_Back_to_List() {		
		driver.findElement(By.xpath("(//*[text()='Back to List'])")).click();
		ngWebDriver.waitForAngularRequestsToFinish();


	}
	
	public void Verify_Team_Present(String country) {		
		driver.findElement(By.xpath("//td[text()='"+country+"']")).isDisplayed();


	}
	
//	public void Team_Info() {	
//		List<WebElement> rowelements = driver.findElements(By.xpath("/html/body/app-root/ng-component/div/div[2]/div"));
//		int rowsize = rowelements.size();
//		System.out.println("No. of players in team are " + rowsize + " which are listed below");
//		
//		List<WebElement> columnelements = ldriver.findElements(By.xpath("/html/body/app-root/ng-component/div/div[2]/div[1]/div"));
//		int colsize = columnelements.size();
//		
//		for(int i=1; i<=rowsize; i++) {
//			for(int j=1; j<=colsize; j++) {
//				
//				System.out.print(ldriver.findElement(By.xpath("/html/body/app-root/ng-component/div/div[2]/div["+ i +"]/div["+ j + "]")).getText()+ " ");
//				
//			}
//			System.out.println();
//		}
//		
//		ngWebDriver.waitForAngularRequestsToFinish();


	}
	
	
	










