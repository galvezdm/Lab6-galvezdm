import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * TODO A simple class that needs to be localized
 *
 * @author mohan.
 *         Created Mar 27, 2011.
 */
public class PrintBalance{

	
	/**
	 * Simple Java Method that is crying out to be localized.
	 *
	 * @param args
	 */
	public static void main(String args[])
	{
		Scanner scanInput = new Scanner(System.in);
		Locale currentLocale;		
		currentLocale = askForLocale();
		System.out.println(getGreeting(currentLocale));
		
		String name = scanInput.nextLine();
		System.out.println(showBalance(currentLocale, name));
	}
	
	public static Locale askForLocale()
	{
		//Asks and receives language and country
		Scanner scanInput = new Scanner(System.in);
		System.out.println("What is the language?");
		String language = scanInput.nextLine();
		System.out.println("What is the country?");
		String country = scanInput.nextLine();
		
		//Sets up proper locale
		Locale currentLocale;
		currentLocale = new Locale(language, country);
		return currentLocale;
	}
	
	public static String getGreeting(Locale currentLocale)
	{
		//Sets up language message bundle
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		
		String greeting;
		//Forms greeting and name request for user
		greeting = messages.getString("greetings") + "\n" + messages.getString("request");
		
		return greeting;
	}

		
	public static String showBalance(Locale currentLocale, String name)
	{		
		String balanceMessage;
		//Sets up language message bundle
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		//Sets up proper date display
		Date today = new Date();
		String correctDate = DateFormat.getDateInstance(DateFormat.LONG, currentLocale).format(today);
		//Sets up proper money display
		double cost = 9876543.21;
		String correctCost = NumberFormat.getInstance(currentLocale).format(cost);
		
		//Forms string that gives date and cost.
		balanceMessage = messages.getString("pleasedToMeet") + name + "\n";
		balanceMessage += messages.getString("asOf")+ correctDate + "\n";
		balanceMessage += messages.getString("youOwe") + "$" + correctCost + "\n";
		balanceMessage += messages.getString("leaving");
		
		return balanceMessage;
	}
}