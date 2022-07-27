package Google;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Busqueda {
	private WebDriver driver;
	private WebDriverWait wait;
	
	// TO-DO: Sacar configuraciones afuera
	private String path = "https://34-176-109-216.thinrdp.net:6580/";
	
	private JavascriptExecutor js;
	private WebElement element;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("disable-gpu");
		driver = new ChromeDriver(options);
		/*String browser = "Chrome";
		if (browser.compareTo("Chrome") == 0)
			driver = new ChromeDriver();
		else if (browser.compareTo("Edge") == 0)
			driver = new EdgeDriver();
		else if (browser.compareTo("Firefox") == 0)
			driver = new FirefoxDriver();
		*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		// Al setear un implicitWait esto no es necesario.
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		
	}

	@AfterMethod
	public void afterMethod() {

		js = null;
		element = null;
		driver.quit();
	}
	private void Sleep()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Busqueda1() {
		driver.get("https://www.google.com");
		
		WebElement input = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		input.sendKeys("EducacionIT");
		
		Sleep();
		
		input.sendKeys(Keys.ENTER);
		
		Sleep();
		
		WebElement link = driver.findElement(By.xpath("//a[@href='https://www.educacionit.com/']"));
		Sleep();
		link.click();
		
		Sleep();
	}
	

}
