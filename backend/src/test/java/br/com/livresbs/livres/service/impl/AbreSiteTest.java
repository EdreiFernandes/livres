package br.com.livresbs.livres.service.impl;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AbreSiteTest {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Unisantos\\Nova pasta\\chromedriver.exe");
		driver = new ChromeDriver();
			
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public final void test() throws InterruptedException, AWTException {
		driver.get("http://localhost:4242/");
		assertEquals("Livres", driver.getTitle());
		
		Thread.sleep(2000);
		
		WebElement username =   driver.findElement(By.xpath("//*[@id='username']"));
		username.sendKeys("grzegorzrudniak@gmail.com");
		
		WebElement senha =   driver.findElement(By.xpath("//*[@id='senha']"));
		senha.sendKeys("grzegorzrudniak@gmail.com");
		Thread.sleep(2000);
		
		WebElement botaoLogin =   driver.findElement(By.xpath("//*[@id='login']"));
		botaoLogin.click(); 
		
		Thread.sleep(1000);
		
		WebElement botaoConsumidores =   driver.findElement(By.xpath("//*[@id='Consumidores']"));
		botaoConsumidores.click(); 
		
		Thread.sleep(1000);
		
		Robot robot = new Robot();
		robot.mouseMove(500,500);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id='linkCadastroConsumidor']")).click();
		
		Thread.sleep(1000);
		
		WebElement nome = driver.findElement(By.xpath("//*[@id='nome']"));
		nome.sendKeys("Thiago");
		
		WebElement sobrenome = driver.findElement(By.xpath("//*[@id='sobrenome']"));
		sobrenome.sendKeys("Ferauche");
		
		WebElement cpf = driver.findElement(By.xpath("//*[@id='cpf']"));
		cpf.sendKeys("12365478976");
		
		WebElement senha2 = driver.findElement(By.xpath("//*[@id='senha']"));
		senha2.sendKeys("1234");
		
	    WebElement testDropDown = driver.findElement(By.id("selectComunidade"));  
	    Select dropdown = new Select(testDropDown);  
	    
	    dropdown.selectByIndex(1);
	    
	    driver.findElement(By.xpath("//*[@id='cadastraConsumidor']")).click();
		
	}

}
