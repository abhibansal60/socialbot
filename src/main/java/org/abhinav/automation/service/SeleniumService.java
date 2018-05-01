package org.abhinav.automation.service;



import java.util.List;

import javax.transaction.Transactional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Service;


@Service("seleniumService")
public class SeleniumService {
	WebDriver driver;
	public void startSelenium(String myusername, String mypassword, String usernameList) {
		System.out.println("Entering --startSelenium in Selenium Service");
		String[] usernames=usernameList.replaceAll("\"", "").split(",");
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\driver\\chromedriver.exe");
    		
    		int count=0;
    		
    		
    			for (int j = 0; j < 20; j++) {
    				
    			
    				try{
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--start-maximized");
    		System.setProperty("webdriver.chrome.driver","C:\\Automation\\driver\\chromedriver.exe");
    		driver = (WebDriver) new ChromeDriver(options);
    		if(!(count<usernames.length))
    			count=0;
    		System.out.println("Total: "+usernames.length+" Number: "+count +" Value: "+usernames[count]); 		
    			String username=usernames[count];
        		count++;
    		driver.get("https://www.instagram.com/"+username+"/followers/");
    		System.out.println("Page Title: "+driver.getTitle());
    		if(!driver.getTitle().contains("Login"))
    			{
    			System.out.println("Please Check your internet connection!");
    			//textArea.setText("Please Check your internet connection!");
    			}
    		Thread.sleep(3000);
    		driver.findElement(By.name("username")).clear();
    		highLight(driver,driver.findElement(By.name("username")));
    		driver.findElement(By.name("username")).sendKeys(myusername);
    		driver.findElement(By.name("password")).clear();
    		unHighLight(driver,driver.findElement(By.name("username")));
    		highLight(driver,driver.findElement(By.name("password")));
    		driver.findElement(By.name("password")).sendKeys(mypassword);
    		unHighLight(driver,driver.findElement(By.name("password")));
    		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    		Thread.sleep(5000);
    		driver.findElement(By.xpath("//a[@href='/"+username+"/followers/']")).click();
    		Thread.sleep(1000);
    		Actions actions1 = new Actions(driver);
    		//WebDriverWait wait = new WebDriverWait(driver, 5);
    		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_6e4x5")));
    		actions1.moveToElement(driver.findElement(By.className("_6e4x5")));
    		actions1.click();
    		List<WebElement> followers = driver.findElements(By.xpath("//button[contains(.,'Follow')]"));
    		List<WebElement> followerName = driver.findElements(By.xpath("//a[@class='_2g7d5 notranslate _o5iw8 ']"));
    		while(followers.size()<41){
    			actions1.sendKeys(Keys.ARROW_DOWN);
    			actions1.build().perform();
    			followers = driver.findElements(By.xpath("//button[contains(.,'Follow')]"));
    			followerName=driver.findElements(By.xpath("//a[@class='_2g7d5 notranslate _o5iw8 ']"));
    		}
    		
    			Thread.sleep(5000);
    		
    		
    		System.out.println("Total Followers: "+followers.size());
    		//textArea.setText("Total Followers: "+followers.size());
    		for (int i=0; i<30; i++) {
    			System.out.println("Following "+followerName.get(i).getText());
    			//textArea.setText("Following "+followerName.get(i).getText());
    			WebElement follower=followers.get(i);
    			Actions actions = new Actions(driver);
    			if(follower.getText().equalsIgnoreCase("Follow")){
    				actions.moveToElement(follower).click().perform();
    			}
    			else{
    				System.out.println("Moving to next follower");
    				//textArea.setText("Moving to next follower");
    				continue;
    			}
    			
    		}
    		
    		Thread.sleep(3000);
    		driver.close();
    				
    		Thread.sleep(3000);
 
    		}catch( org.openqa.selenium.NoSuchElementException e1){
    			//e1.printStackTrace();
    	System.out.println("Element not found countinue!!");
    
	}catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	finally{
    		driver.quit();
    	}			
    	}
	}
	
    public  void highLight(WebDriver driver, WebElement element){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public void unHighLight(WebDriver driver, WebElement element){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].setAttribute('style', 'background: none; border: none;');", element);
    }

	
}

