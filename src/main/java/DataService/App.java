package DataService;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	DateService dateService = new DateService();
		
		Date birthDate = dateService.askUserForDate();
		int age = dateService.getAge(birthDate);
		System.out.println("Your age is: "+age);
    }
}
