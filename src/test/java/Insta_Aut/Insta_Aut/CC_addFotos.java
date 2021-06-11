package Insta_Aut.Insta_Aut;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CC_addFotos {
	public int Random() {

		final int min = Math.min(1, 3);
		final int max = Math.max(1, 3);
		Random r = new Random();

		return (min + r.nextInt((max - min) + 1));
	}
	public int Random1() {

		final int min = Math.min(1, 7);
		final int max = Math.max(1, 7);
		Random r = new Random();

		return (min + r.nextInt((max - min) + 1));
	}

	@Test	
	
	public void test(dados d) {
		
		try {
			
		// Assert.assertEquals(1, 1);
		Class<ChromeDriver> driverClass = ChromeDriver.class;
		WebDriverManager.getInstance(driverClass).setup();
		WebDriver navegador = driverClass.newInstance();

		navegador.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		String senha = d.getSenha();

		navegador.get("https://messages.google.com/web/conversations?hl=pt-BR");
		navegador.findElement(By.cssSelector("#mat-slide-toggle-1 > label > div")).click();
		
		
		WebDriverWait wait = new WebDriverWait(navegador, 300); // Espera 10 minutos para colocar o web message
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"/html/body/mw-app/mw-bootstrap/div/main/mw-main-container/div/mw-main-nav/div/mw-fab-link/a/span[1]/div[2]")));
		
		((JavascriptExecutor) navegador).executeScript("window.open('about:blank', '_blank');"); // abre nova aba

		ArrayList<String> tabs2 = new ArrayList<String>(navegador.getWindowHandles());
		navegador.switchTo().window(tabs2.get(1));
		navegador.get("http://www.instagram.com/accounts/emailsignup/?hl=pt-br");
		
		navegador.findElement(By.name("emailOrPhone")).sendKeys(d.getTel_Email()); // Digita o telefone
		navegador.findElement(By.name("fullName")).sendKeys(d.getNome()); // Digita o nome
		navegador.findElement(By.name("username")).sendKeys(d.getNome()); // Digita o usuário
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Espera aparecer o botão de gerar usuário
		navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/form/div[5]/div/div/div/button"))
				.click(); // gera o usuário
		navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/form/div[6]/div/label/input"))
				.sendKeys(senha); // Digita a senha
		navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/form/div[7]/div/button"))
				.click(); // Clica em cadastre-se

		switch (this.Random()) { // Gera uma data
		case 1:
			navegador.findElement(By.xpath(
					"/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[1]/select/option[6]"))
					.click();
			navegador.findElement(By.xpath(
					"/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[3]/select/option[25]"))
					.click();
			break;
		case 2:
			navegador.findElement(By.xpath(
					"/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[1]/select/option[9]"))
					.click();
			navegador.findElement(By.xpath(
					"/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[3]/select/option[24]"))
					.click();
			break;
		case 3:
			navegador.findElement(By.xpath(
					"/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[1]/select/option[8]"))
					.click();
			navegador.findElement(By.xpath(
					"/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[3]/select/option[30]"))
					.click();
			break;
		}
		navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[6]/button")).click(); // Clica para cadastrar e espera a chegada código (sms)
		
		
		// ------- pega o código de verificação (sms)
		navegador.switchTo().window(tabs2.get(0)); // vai pra guia do google messagens
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("para verificar a conta do Instagram."))); //espera uma mensagem que contenha no texto "para verificar a conta do Instagram."

		navegador.findElement(By.partialLinkText("para verificar a conta do Instagram.")).click(); //Clica na mensagem
		String msg = navegador.findElement(By.partialLinkText("para verificar a conta do Instagram.")).getText(); //Pega o texto da mensagem
		String cod = msg.replaceAll("[^0-9]", "").substring(5,11); // Tira as letras e deixa só os números
		navegador.findElement(By.xpath("/html/body/mw-app/mw-bootstrap/div/main/mw-main-container/div/mw-conversation-container/div/div[1]/div/mws-messages-list/mws-bottom-anchored/div/div/div/mws-message-wrapper/div/div/div/mws-message-part-router/mws-text-message-part/div/div/mws-message-part-content/div/div")).click();
		navegador.findElement(By.className("msg-action-menu-icon")).click();
		navegador.findElement(By.xpath("/html/body/div[5]/div[2]/div/div/div/div/button[2]")).click();
		navegador.findElement(By.xpath("/html/body/div[5]/div[2]/div/mat-dialog-container/mws-dialog/div/mat-dialog-actions/button[2]/span[1]")).click(); // Apaga a mensagem
		
		// ---------------------------------------------------------
		

		navegador.switchTo().window(tabs2.get(1)); // Volta para a guia do insta
		
		navegador.findElement(By.name("confirmationCode")).sendKeys(cod);
		navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div/div/form/div[2]/button")).click();
		
		//--------------------------
		//------ Tirando o telefone e colocando um email aleatório
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")));//Espera o botão 'agora não'
		navegador.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")).click(); // Agora não
		navegador.findElement(By.xpath("/html/body/div[1]/section/nav/div[2]/div/div/div[3]/div/div[5]/span/img")).click(); //Clica no ícone do perfil
		navegador.findElement(By.xpath("/html/body/div[1]/section/nav/div[2]/div/div/div[3]/div/div[5]/div[2]/div[2]/"
				+ "div[2]/a[3]/div/div[2]/div/div/div/div")).click();//Clica em configurações

		
		String user = navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/article/div/div[2]/h1")).getText();
		
		//.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Keys.BACK_SPACE);   -- apaga um campo
		//.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);   -- apaga um campo
		
		navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/article/form/div[7]/div/div/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE); // Apaga o telefone
		PegandoDad p = new PegandoDad();
		navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/article/form/div[6]/div/div/input")).sendKeys(p.emailAleatorio()); //Põe um email aleatório
		
		switch (this.Random1()) { // Gera uma bio
		case 1:
			navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/article/form/div[4]/div/textarea")).sendKeys("21 anos :')\r\n" + 
					"Salvador - BA\r\n" + 
					"Às vezes ouço passar o vento, e só de ouvir o vento passar, vale a pena ter nascido <3");
			
			break;
		case 2:
			navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/article/form/div[4]/div/textarea")).sendKeys("22 anos :)\r\n" + 
					"Vitória - ES \r\n" + 
					"Viver é a coisa mais rara do mundo. A maioria das pessoas apenas existem.");
			break;
		case 3:
			navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/article/form/div[4]/div/textarea")).sendKeys("23 anos :')\r\n" + 
					"Recife - PE \r\n" + 
					"Para viajar basta existir.");			
			break;
		case 4:
			navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/article/form/div[4]/div/textarea")).sendKeys("24 anos :)\r\n" + 
					"João Pessoa - PB \r\n" + 
					"Somos feitos de carne, mas temos de viver como se fôssemos de ferro. :')");				
			break;
		case 5:
			navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/article/form/div[4]/div/textarea")).sendKeys("20 anos :')\r\n" + 
					"Natal - RN \r\n" + 
					"A alegria evita mil males e prolonga a vida <3");			
			break;
		case 6:
			navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/article/form/div[4]/div/textarea")).sendKeys("20 anos :)\r\n" + 
					"São Luís - MA \r\n" + 
					"Tudo vale a pena quando a alma não é pequena.");			
			break;
		case 7:
			navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/article/form/div[4]/div/textarea")).sendKeys("23 anos :')\r\n" + 
					"Teresina - PI \r\n" + 
					"Não existe um caminho para a felicidade. A felicidade é o caminho <3");			
			break;
		}
		
		navegador.findElement(By.xpath("/html/body/div[1]/section/main/div/article/form/div[10]/div/div/button")).click();// Clica para salvar
		
		
		//---- Salvando usuário e senha
		String userdir = System.getProperty("user.dir");
		FileOutputStream arquivo = new FileOutputStream(userdir+"\\senhas.txt", true);
		//FileWriter fw = new FileWriter("../Dados/dados.txt/");
		
		PrintWriter pw = new PrintWriter(arquivo);
		pw.println(user);
		pw.println(d.getSenha());
		pw.close();
		arquivo.close();	
		//-----------------

		//navegador.close();
		//navegador.close();
		//
		Class<ChromeDriver> driverClass1 = ChromeDriver.class;
		WebDriverManager.getInstance(driverClass1).setup();
		//WebDriver navegador = driverClass.newInstance();


		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "Galaxy S5");

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("mobileEmulation", mobileEmulation);
		ChromeDriver navegador1 = new ChromeDriver(options);
		//
		navegador1.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		navegador1.get("https://www.instagram.com/accounts/login/?source=auth_switcher");
		//----login
		navegador1.findElement(By.name("username")).sendKeys(user);
		navegador1.findElement(By.name("password")).sendKeys(d.getSenha());
		
		navegador1.findElement(By.xpath("/html/body/div[1]/section/main/div[1]/div/div/div/form/div[1]/div[6]/button")).click();
		WebDriverWait wait1 = new WebDriverWait(navegador1, 60);
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/main/div/div/div/button")))); //Espera o botão agora não aparecer

		navegador1.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div/button")).click();
		
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[4]/div/div/div/div[3]/button[2]"))));//Espera abrir outra tela para cancelar
		navegador1.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")).click();//Clica no botão cancelar

		
		navegador1.findElement(By.xpath("/html/body/div[1]/section/nav[2]/div/div/div[2]/div/div/div[5]/a/span/img")).click(); //Clica no botão para ir para o perfil
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/main/div/header/div/div/div/button/img"))));//Espera aparecer a opção de por a foto de perfil

		
		//Adicionar foto de perfil
		navegador1.findElement(By.xpath("/html/body/div[1]/section/main/div/header/div/div/div/button/img")).click();

		Robot rob = new Robot();
		rob.setAutoDelay(500);
		
		StringSelection stringSelection = new StringSelection(d.getPasta()+"\\"+d.getPasta_fotos()+"\\perfil.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		rob.setAutoDelay(300);
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_V);
		
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
		navegador1.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click(); //Poe a foto de perfil
		
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[4]/div/div/div/div[2]/button[1]"))));
		navegador1.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/button[1]")).click(); //Publica a foto de perfil
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[4]/div/div/div/div[3]/button[2]"))));
		navegador1.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")).click(); // Agora não
		
		//Foto 1
		navegador1.findElement(By.cssSelector("#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > svg")).click();
		rob.setAutoDelay(500);
		
		StringSelection stringSelection1 = new StringSelection(d.getPasta()+"\\"+d.getPasta_fotos()+"\\1.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);
		
		rob.setAutoDelay(300);
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_V);
		
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
		navegador1.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[2]/section[2]/button/span[1]"))));
		navegador1.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
		
		//Foto 2
		for (int i=2; i<=9; i++) {
			wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[3]/div/div/div/p"))));
			navegador1.findElement(By.cssSelector("#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > svg")).click();
			rob.setAutoDelay(500);
			
			StringSelection stringSelection2 = new StringSelection(d.getPasta()+"\\"+d.getPasta_fotos()+"\\"+i+".jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection2, null);
			
			rob.setAutoDelay(300);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[1]/header/div/div[2]/button"))));
			navegador1.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
			wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("/html/body/div[1]/section/div[2]/section[2]/button/span[1]"))));
			navegador1.findElement(By.xpath("/html/body/div[1]/section/div[1]/header/div/div[2]/button")).click();
		}

		//navegador.close();
		
		JOptionPane.showMessageDialog(null,
				"Deu tudo certo! Conta criada com sucesso!");

		
		}catch(Exception e ){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Algo deu errado");
		}
	}
}
