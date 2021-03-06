package incubyte_Script.incubyte_Script;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GmailCompose {

	WebElement Username, Nextbtn, Compose;

	@Test
	public void driversetup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriverversion-86\\chromedriver.exe");

		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		// Launch the URL
		driver.get("https://mail.google.com/");

		// To Maximize the browser window
		driver.manage().window().maximize();

		// Create new WebDriver wait
		WebDriverWait wait = new WebDriverWait(driver, 40);

		// Entering the Email Id in Username textbox
		wait.until(explicitwait(By.xpath("//input[@type='email']"))).sendKeys("nandytestmail@gmail.com");
		Username = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='dG5hZc']//div[@class='VfPpkd-Jh9lGc']")));
		Actions ac = new Actions(driver);
		ac.click(Username).build().perform();

		// Entering the Passoword in Password textbox
		wait.until(explicitwait(By.xpath("//input[@type='password']")))
				.sendKeys("Password1");

		// Clicking on "Next" Button
		Nextbtn = driver.findElement(By.xpath("//div[@class='dG5hZc']//div[@class='VfPpkd-Jh9lGc']"));
		ac.click(Nextbtn).build().perform();

		// wait until the element to be appeared in webpage and then Clicking on
		// "Compose" Option
		Compose = wait.until(explicitwait(By.xpath("//div[@class='z0']//div[@class='T-I T-I-KE L3']")));
		ac.moveToElement(Compose).click(Compose).build().perform();
		ac.click();

		// wait until the element to be appeared in webpage and then Clicking on
		// "To" Section in compose mail window
		wait.until(explicitwait(By.xpath(".//textarea[contains(@aria-label, 'To')]")))
				.click();

		// Entering the Mail id in To section
		WebElement Toelement=driver.findElement(By.xpath(".//textarea[contains(@aria-label, 'To')]"));
		Toelement.sendKeys("nandytestmail@gmail.com");
		Toelement.sendKeys(Keys.ENTER);
		

		//// wait until the element to be visible in webpage and then Clicking on "subject" area in compose mail window
		wait.until(explicitwait(By.xpath("//div[@class='aoD az6']//input[@name='subjectbox']"))).click();

		// Entering the text in Subject area
		driver.findElement(By.xpath("//div[@class='aoD az6']//input[@name='subjectbox']")).sendKeys("Hello");

		wait.until(
				explicitwait(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")))
				.click();

		// Entering the Message in Email Body section
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']"))
				.sendKeys("Dear Nisha ,\r\n\n" + "Thanks for your time\r\n\n" + "Thanks\n" + "Nandhini K");
		
		
		// Clicking on send button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")))
				.click();
		
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.gb_Da.gbii"))).click();
		
		//Clicking on "Sign-out" button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='gb_Db gb_Uf gb_3f gb_Qe gb_4c']"))).click();
		
		//To close the browser window
		driver.quit();
		

	}

	public ExpectedCondition<WebElement> explicitwait(By locator) {

		return ExpectedConditions.visibilityOfElementLocated(locator);
	}

}
