package Insta_Aut.Insta_Aut;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Parameterized.class)
public class CriaConta_SemMensagens {
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

		WebDriverWait wait = new WebDriverWait(navegador, 300); // Espera 10 minutos para colocar o web message

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
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[6]/button")));
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
		
		JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");		
		
		}catch(Exception e ){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Algo deu errado");
		}
	}
}