package Insta_Aut.Insta_Aut;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class PegandoDad {

	public String masculino() throws IOException {
		Document doc = Jsoup.connect("https://pt.fakenamegenerator.com/gen-male-br-br.php").timeout(9000).get();
		Elements nome = doc.select("div.address h3");
		return (nome.text());
	}

	public String feminino() throws IOException {
		Document doc = Jsoup.connect("https://pt.fakenamegenerator.com/gen-female-br-br.php").timeout(9000).get();
		Elements nome = doc.select("div.address h3");
		return (nome.text());
	}
	public String emailAleatorio() throws IOException {
		Document doc1 = Jsoup.connect("https://www.invertexto.com/gerador-email-temporario").timeout(9000).get();
		Elements email = doc1.select("div.input-group input");
		return email.attr("value");
	}
	
//		TESTES
//	public static void main(String[] args) throws IOException {
//		Document doc = Jsoup.connect("https://pt.fakenamegenerator.com/gen-random-br-br.php").timeout(9000).get();
//		Elements nome = doc.select("div.address h3");
//
//		System.out.println(nome.text());
//
//		Document doc1 = Jsoup.connect("https://www.invertexto.com/gerador-email-temporario").timeout(9000).get();
//		Elements email = doc1.select("div.input-group input");
//		System.out.println(email.attr("value"));
//
//		// System.out.println(doc.getElementsByTag("h3"));
//		// System.out.println(doc.getElementById("details"));
//
//		Document doc2 = Jsoup.connect("https://messages.google.com/web/conversations/94").timeout(9000).get();
//
//		Elements msg = doc2.select("span.ng-star-inserted");
//		System.out.println(msg.text());
//
//		PegandoDad pp = new PegandoDad();
//		pp.emailAleatorio();
//		
//		
//		for (Element element : doc2.getElementsByClass("msg-focus-element.ng-star-inserted")) {
//			Elements codigo = element.getElementsByTag("span");
//
//			System.out.println(codigo);
//		}
//
//		int[] iniciaValores = { 12, 32, 54, 6, 8, 89, 64, 64, 6 };
//
//		for (int i = 0; i < iniciaValores.length; i++) {
//			System.out.println(iniciaValores[i]);
//
//		}
//	}
}
