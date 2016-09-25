package DataService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class DateService {
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

	public Date askUserForDate() {
		boolean validDate = false;
		Date date = null;
		while (!validDate) {
			try {
				date = askForDate();
				validDate = true;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Format daty niepoprawny", "Bład", JOptionPane.ERROR_MESSAGE);
			}
		}
		return date;
	}

	private Date askForDate() throws ParseException {
		return DATE_FORMATTER.parse(JOptionPane.showInputDialog("Podaj date urodzenia w formacie yyyy-MM-dd"));
	}

	public int getAge(Date birthDate) {
		UserDate today = new UserDate(new Date());
		UserDate hisBirthday = new UserDate(birthDate);

		int age = today.getYear() - hisBirthday.getYear();
		if (isMonthNotPassed(today, hisBirthday) || isDayInMonthNotPassed(today, hisBirthday)) {
			age -= 1;
		}
		return age;
	}

	private boolean isDayInMonthNotPassed(UserDate today, UserDate hisBirthday) {
		return today.getMonth() == hisBirthday.getMonth() && today.getDate() < hisBirthday.getDate();
	}

	private boolean isMonthNotPassed(UserDate today, UserDate hisBirthday) {
		return today.getMonth() < hisBirthday.getMonth();
	}

	private final class UserDate {
		private final int year;
		private final int month;
		private final int date;

		public UserDate(Date date) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			this.year = cal.get(Calendar.YEAR);
			this.month = cal.get(Calendar.MONTH);
			this.date = cal.get(Calendar.DATE);
		}

		public int getYear() {
			return year;
		}

		public int getMonth() {
			return month;
		}

		public int getDate() {
			return date;
		}

	}
}
