
/* 
 * CSCI 221, Fall 2017, HW 3
 * 
 * Program to prompt the user for the date of their birth and tell them 
 * something about that date.
 * 
 * Base code provided by instructor. The following updates 
 * 
 *    (everything that was asked for in the comments, and the pdf file.)
 * 
 * were added by
 * 
 *   Arthur Gabriel
 */

import java.util.*;

public class BirthDate {
	public static void main(String[] args) {

		SampleDate birthdate = getBirthdate();
		details(birthdate);
		daysUntilBirthday(birthdate);
		daysOld(birthdate);
	}

	/*
	 * prompt user for their birthdate and return it as a CalendarDate
	 */
	private static SampleDate getBirthdate() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("What month, day, and year were you born? ");
		int month = sc.nextInt();
		int day = sc.nextInt();
		int year = sc.nextInt();
		sc.close();
		SampleDate birthdate = new SampleDate(year, month, day);
		return birthdate;

	}

	// print stats about user's birthdate
	private static void details(SampleDate birthdate) {
		System.out.print("You were born on " + birthdate + ", which was a ");
		System.out.println(birthdate.getDayOfWeek() + ".");
		if (birthdate.isLeapYear()) {
			System.out.println(birthdate.getYear() + " was a leap year.");
		}
	}

	/*
	 * Count # days until next birthday.
	 */
	private static void daysUntilBirthday(SampleDate birthdate) {
		
		SampleDate today = new SampleDate();
		if ((today.getDay() == birthdate.getDay()) && 
				today.getMonth() == birthdate.getMonth()) {
			System.out.println("Happy Birthday! You are now age " 
				+ (today.getYear() - birthdate.getYear()) + ".");
		} else {
			int daysUntilBirthday = 0;
			while ((birthdate.getDay() != today.getDay()) || 
					(birthdate.getMonth() != today.getMonth())) {

				daysUntilBirthday++;
				today.nextDay();

			}

			System.out.println("It will be your birthday in " + daysUntilBirthday + " days.");
				
		}

		// Hint: count the days from today's date until the user's next birthday
		// If today is the birthday, print Happy Birthday message
		// if not print the message stating the number of days until the user's
		// next birthday

	}

	/*
	 * count # days old this person is
	 */
	private static void daysOld(SampleDate birthdate) {
		SampleDate today = new SampleDate();

		int daysOld = 0;
		// Hint: count the days from birthdate to today's date
		while (!(birthdate.equals(today))) {
			daysOld++;
			birthdate.nextDay();

		}
		System.out.println("You are " + daysOld + " days old.");
	}
}