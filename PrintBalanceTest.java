import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Locale;
import org.junit.Test;

public class PrintBalanceTest {
	@Test
	public void test_JUnit(){
		assertTrue("The compiler isn't feeling well today...", true);
	}
	
	@Test
	public void testFrenchGreeting(){
		Locale frenchLocale = new Locale("fr", "FR");
		assertEquals(PrintBalance.getGreeting(frenchLocale),"Bonjour tout le monde!\nS'il vous plaît entrer votre nom");
	}
	
	@Test
	public void testFrenchBalanceShow(){
		Locale frenchLocale = new Locale("fr", "FR");
		assertEquals(PrintBalance.showBalance(frenchLocale, "Person"),
				"Je suis heureux de vous rencontrer Person\nComme d'9 avril 2012\nVous devez l'école $9 876 543,21\nAu revoir");
	}
	
	@Test
	public void testGermanGreeting(){
		Locale germanLocale = new Locale("de", "DE");
		assertEquals(PrintBalance.getGreeting(germanLocale),"Hallo Welt!\nBitte geben Sie Ihren Namen");
	}
	
	@Test
	public void testGermanBalanceShow(){
		Locale germanLocale = new Locale("de", "DE");
		assertEquals(PrintBalance.showBalance(germanLocale, "Person"),
				"Ich freue mich, Sie kennen zu lernen Person\nAb 9. April 2012\nSie schulden die Schule $9.876.543,21\nAuf Wiedersehen");
	}
	
	@Test
	public void testEnglishGreeting(){
		Locale englishLocale = new Locale("en", "US");
		assertEquals(PrintBalance.getGreeting(englishLocale),"Hello World!\nPlease enter your name");
	}
	
	@Test
	public void testEnglishBalanceShow(){
		Locale englishLocale = new Locale("en", "US");
		assertEquals(PrintBalance.showBalance(englishLocale, "Person"),
				"I am pleased to meet you Person\nAs of April 9, 2012\nYou owe the school$9,876,543.21\nGood Bye");
	}
	
	@Test
	public void testEnglishGreetingAnywhere(){
		Locale englishLocale = new Locale("en", "adfadferkjlerj");
		assertEquals(PrintBalance.getGreeting(englishLocale),"Hello World!\nPlease enter your name");
	}
}
