package br.com.livresbs.livres.service.impl;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Value;

public class AbreSiteTest {

	
	@Rule
	public TestName name = new TestName();

	private WebDriver driver;
	
	@Value("${path.chrome}") private String pathChrome;

	@Before
	public void setUp() throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
		System.setProperty("webdriver.chrome.driver", pathChrome);
		driver = new ChromeDriver(options);
		driver.get("http://localhost:4242/");
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws Exception {
		if (name.getMethodName().equals("TesteCadastraUsuario")) {
			URL url = new URL("http://livresbs.herokuapp.com/api/consumidor/12365478976");
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("DELETE");
			int responseCode = httpCon.getResponseCode();
			System.out.println("delete request code: " + responseCode);
		}

		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public final void TesteCadastraUsuario() throws InterruptedException, AWTException {

		WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
		username.sendKeys("grzegorzrudniak@gmail.com");

		WebElement senha = driver.findElement(By.xpath("//*[@id='senha']"));
		senha.sendKeys("grzegorzrudniak@gmail.com");
		Thread.sleep(2000);

		WebElement botaoLogin = driver.findElement(By.xpath("//*[@id='login']"));
		botaoLogin.click();

		Thread.sleep(1000);

		WebElement botaoConsumidores = driver.findElement(By.xpath("//*[@id='Consumidores']"));
		botaoConsumidores.click();

		Thread.sleep(1000);

		Robot robot = new Robot();
		robot.mouseMove(600, 600);

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

		Thread.sleep(2000);

	}

	@Test
	public final void testeCadastraUsuarioRepetido() throws InterruptedException, AWTException {

		
		WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
		username.sendKeys("grzegorzrudniak@gmail.com");

		WebElement senha = driver.findElement(By.xpath("//*[@id='senha']"));
		senha.sendKeys("grzegorzrudniak@gmail.com");
		Thread.sleep(2000);

		WebElement botaoLogin = driver.findElement(By.xpath("//*[@id='login']"));
		botaoLogin.click();

		Thread.sleep(1000);

		WebElement botaoConsumidores = driver.findElement(By.xpath("//*[@id='Consumidores']"));
		botaoConsumidores.click();

		Thread.sleep(1000);

		Robot robot = new Robot();
		robot.mouseMove(500, 500);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='linkCadastroConsumidor']")).click();

		Thread.sleep(1000);

		WebElement nome = driver.findElement(By.xpath("//*[@id='nome']"));
		nome.sendKeys("Gabriel");

		WebElement sobrenome = driver.findElement(By.xpath("//*[@id='sobrenome']"));
		sobrenome.sendKeys("Jardim");

		WebElement cpf = driver.findElement(By.xpath("//*[@id='cpf']"));
		cpf.sendKeys("123451231231");

		WebElement senha2 = driver.findElement(By.xpath("//*[@id='senha']"));
		senha2.sendKeys("1234");

		WebElement testDropDown = driver.findElement(By.id("selectComunidade"));
		Select dropdown = new Select(testDropDown);

		dropdown.selectByIndex(1);

		driver.findElement(By.xpath("//*[@id='cadastraConsumidor']")).click();

		assertEquals("http://localhost:4242/consumidores/cadastro", driver.getCurrentUrl());
	}

}
