package Insta_Aut.Insta_Aut;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddFotos {

	@Test
	public void test(dados d) {
		try {

			Class<ChromeDriver> driverClass = ChromeDriver.class;
			WebDriverManager.getInstance(driverClass).setup();
			//WebDriver navegador = driverClass.newInstance();


			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Galaxy S5");

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("mobileEmulation", mobileEmulation);
			ChromeDriver navegador = new ChromeDriver(options);
			
			navegador.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			
			navegador.get("https://www.instagram.com/accounts/login/?source=auth_switcher");
			//----login
			navegador.findElement(By.name("username")).sendKeys(d.getUsuario());
			navegador.findElement(By.name("password")).sendKeys(d.getSenha());
			
			navegador.findElement(By.xpath("/html/body/div[1]/section/main/div[1]/div/div/div/form/div[1]/div[6]/button")).click();
			WebDriverWait wait = new WebDriverWait(navegador, 60);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/main/div/div/div/button")))); //Espera o botão agora não aparecer
			navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div/button")).click();//Clica no botão agora não
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[4]/div/div/div/div[3]/button[2]"))));//Espera abrir outra tela para cancelar
			navegador.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")).click();//Clica no botão cancelar

			
			navegador.findElement(By.xpath("/html/body/div[1]/section/nav[2]/div/div/div[2]/div/div/div[5]/a/span/img")).click(); //Clica no botão para ir para o perfil
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/main/div/header/div/div/div/button/img"))));//Espera aparecer a opção de por a foto de perfil

			
			//Adicionar foto de perfil
			navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/header/div/div/div/button/img")).click();

			Robot rob = new Robot();
			rob.setAutoDelay(2000);
			
			StringSelection stringSelection = new StringSelection(d.getPasta()+"\\perfil.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			
			rob.setAutoDelay(400);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click(); //Poe a foto de perfil
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[4]/div/div/div/div[2]/button[1]"))));
			navegador.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/button[1]")).click(); //Publica a foto de perfil
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[4]/div/div/div/div[3]/button[2]"))));
			navegador.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")).click(); // Agora não
			
			//Foto 1
			navegador.findElement(By.cssSelector("#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > svg")).click();
			rob.setAutoDelay(2000);
			
			StringSelection stringSelection1 = new StringSelection(d.getPasta()+"\\1.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);
			
			rob.setAutoDelay(400);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[2]/section[2]/button/span[1]"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			
			//Foto 2
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[3]/div/div/div/p"))));
			navegador.findElement(By.cssSelector("#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > svg")).click();
			rob.setAutoDelay(2000);
			
			StringSelection stringSelection2 = new StringSelection(d.getPasta()+"\\2.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection2, null);
			
			rob.setAutoDelay(400);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[2]/section[2]/button/span[1]"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			
			//Foto 3
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[3]/div/div/div/p"))));
			navegador.findElement(By.cssSelector("#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > svg")).click();
			rob.setAutoDelay(2000);
			
			StringSelection stringSelection3 = new StringSelection(d.getPasta()+"\\3.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection3, null);
			
			rob.setAutoDelay(400);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[2]/section[2]/button/span[1]"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			
			//Foto 4
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[3]/div/div/div/p"))));
			navegador.findElement(By.cssSelector("#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > svg")).click();
			rob.setAutoDelay(2000);
			
			StringSelection stringSelection4 = new StringSelection(d.getPasta()+"\\4.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection4, null);
			
			rob.setAutoDelay(400);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[2]/section[2]/button/span[1]"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			
			//Foto 5
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[3]/div/div/div/p"))));
			navegador.findElement(By.cssSelector("#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > svg")).click();
			rob.setAutoDelay(2000);
			
			StringSelection stringSelection5 = new StringSelection(d.getPasta()+"\\5.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection5, null);
			
			rob.setAutoDelay(400);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[2]/section[2]/button/span[1]"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			
			//Foto 6
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[3]/div/div/div/p"))));
			navegador.findElement(By.cssSelector("#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > svg")).click();
			rob.setAutoDelay(2000);
			
			StringSelection stringSelection6 = new StringSelection(d.getPasta()+"\\6.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection6, null);
			
			rob.setAutoDelay(400);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[2]/section[2]/button/span[1]"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			
			//Foto 7
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[3]/div/div/div/p"))));
			navegador.findElement(By.cssSelector("#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > svg")).click();
			rob.setAutoDelay(2000);
			
			StringSelection stringSelection7 = new StringSelection(d.getPasta()+"\\7.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection7, null);
			
			rob.setAutoDelay(400);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[2]/section[2]/button/span[1]"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			
			//Foto 8
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[3]/div/div/div/p"))));
			navegador.findElement(By.cssSelector("#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > svg")).click();
			rob.setAutoDelay(2000);
			
			StringSelection stringSelection8 = new StringSelection(d.getPasta()+"\\8.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection8, null);
			
			rob.setAutoDelay(400);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[2]/section[2]/button/span[1]"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			
			//Foto 9
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[3]/div/div/div/p"))));
			navegador.findElement(By.cssSelector("#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > svg")).click();
			rob.setAutoDelay(2000);
			
			StringSelection stringSelection9 = new StringSelection(d.getPasta()+"\\9.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection9, null);
			
			rob.setAutoDelay(400);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[2]/section[2]/button/span[1]"))));
			navegador.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();		
			
			//navegador.close();
			
			JOptionPane.showMessageDialog(null, "Deu tudo certo! Todas as fotos foram postadas!");
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Algo deu errado");
		}
	}

}
