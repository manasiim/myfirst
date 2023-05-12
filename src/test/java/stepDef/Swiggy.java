package stepDef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Swiggy {
	public	WebDriver driver ; 
	public Properties configProp ;
	ChromeOptions options = new ChromeOptions();
	public static Logger logger;



	@Before
	public void setup() throws IOException {

		//Logging
		logger=Logger.getLogger("ownProjectCreation");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);


		//Load properties file
		configProp= new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);
		//getting the browser name from config.properties file
		String br=configProp.getProperty("browser"); 
		System.out.println(br);
		

	}

	@After
	public void tearup(){
		
	
	}
	
	@Given("User open chrome browser")
	public void user_open_chrome_browser() {
		// Write code here that turns the phrase above into concrete actions
		logger.info("************* Launching Browser *****************");
		System.out.println("Open website");
	}

	@When("user enter https:\\/\\/www.swiggy.com\\/ to open Website")
	public void user_enter_https_www_swiggy_com_to_open_Website() {
		// Write code here that turns the phrase above into concrete actions

		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.swiggy.com/");
	}

	@Then("User visit to the URL")
	public void user_visit_to_the_URL() {
		// Write code here that turns the phrase above into concrete actions
		String a=driver.getCurrentUrl();
		System.out.println(a);
		driver.close();
	
	}
}
