package DataService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase{
	DateService ds = new DateService();
	
	@Before
	public void setUp() throws Exception {
		// 1) askUserForDate()
		// given
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String givenDate = dateFormat.format(ds.askUserForDate());
		dateFormat.setLenient(false);
		//when
		try {
			dateFormat.parse(givenDate);
		} 
		//then
		catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		//2)month in 1-12
		//given
		//"yyyy-MM-dd"
		String year = givenDate.substring(0,4);
<<<<<<< HEAD
		System.out.println("Urodzilas sie miesiaca: "+ year);
		String month = givenDate.substring(5, 7);
		System.out.println("Urodzilas sie miesiaca: "+ month);
		String day = givenDate.substring(8,10);
		System.out.println("Urodzilas sie miesiaca: "+ day);
=======
		String month = givenDate.substring(6, 7);
		String day = givenDate.substring(8,9);
>>>>>>> branch 'master' of https://github.com/JolantaWojcik/DateServiceTest.git
		
		int yearNr = Integer.parseInt(year);
		int monthNr = Integer.parseInt(month);
		int dayNr = Integer.parseInt(day);
		System.out.println("Urodzilas sie miesiaca: "+ monthNr);
		
		if (!(monthNr > 0 && monthNr < 13)) {
			throw new Exception("Incorrect month");
		}
		
		if ((dayNr >0 && dayNr < 32) && (monthNr == 1 || monthNr == 3 || monthNr == 5 ||
				monthNr == 7 || monthNr == 8 || monthNr == 10 || monthNr == 12)) {
			System.out.println("Urodzilas sie dnia: "+ dayNr);
		}
		else if ((dayNr >0 && dayNr < 31) && (monthNr == 4 || monthNr == 6 || monthNr == 9 ||
				monthNr == 11)) {
			System.out.println("Urodzilas sie dnia: "+ dayNr);
		}
		else if ((dayNr >0 && dayNr < 30 && leapYear(yearNr)) ||
				(dayNr >0 && dayNr < 29 && !leapYear(yearNr))) {
			System.out.println("Urodzilas sie dnia: "+ dayNr);
		}else{
			throw new Exception("Incorrect day");
		}
	}
	
	private static boolean leapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		else
			return false;
	}
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
