package Fbtest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testCase1 {
	
	WebDriver driver;
	
	@BeforeClass
	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\msuser1\\Documents\\Workspace\\Celin\\Cha\\Chrome\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void fbLoginPage() throws Exception {
		driver.get("https://www.facebook.com");
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("karthick.gunapati@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pass")).sendKeys("9492638386");
	}

	@Test(priority=2)
	public void fbForgot() throws Exception {
		driver.findElement(By.linkText("Forgotten password?")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("identify_email")).sendKeys("karthick.gunapati@gmail.com");
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().back();
	}
	
	@Test(priority=3)
	public void fbCreateacct() throws Exception {
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("firstname")).sendKeys("Kartheek");
		Thread.sleep(3000);
		driver.findElement(By.name("lastname")).sendKeys("Gunapati");
		Thread.sleep(3000);
		driver.navigate().refresh();
		
	}
	
	@Test(priority=4)
	public void fbLogin() throws Exception {
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("karthick.gunapati@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pass")).sendKeys("9492638386");
		Thread.sleep(3000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//i[@class='hu5pjgll lzf7d6o1 sp_lc7enIG-olz sx_b91a3e']")).click();
		//Thread.sleep(3000);
		//String logout = "//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span";
		//driver.findElement(By.xpath(logout)).click();
		
	}

	
	@AfterClass
	public void browserClose() throws Exception {
		driver.quit();
	}
}
