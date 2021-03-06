/*
 * Represents a calendar year/month/day date.
 */ 

import java.util.*;

public class CalendarDate {
    // constants that may be helpful in avoiding "magic numbers"
    // in your code making it more readable and extendable
    private static final int JANUARY  =  1;
    private static final int FEBRUARY =  2;
    private static final int DECEMBER = 12;
    private static final int DAYS_PER_WEEK = 7;
    
    // these arrays that might simplify your code - remove if
    // you don't use them
    private static final String[] DAY_NAMES = {
        //    0,        1,         2,           3,
        "Sunday", "Monday", "Tuesday", "Wednesday",
        //    4,        5,         6
        "Thursday", "Friday", "Saturday"};

    private static final int[] DAYS_PER_MONTH = { -1,
    //   1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,
    };

    // fields - should not change
    private int year;
    private int month;
    private int day;

    // constructor(s)
    
    /*
     * Constructs a new CalendarDate to represent the specified year/month/day.
     */
    public CalendarDate(int year, int month, int day) {
       this.year = year;
       this.month = month;
       this.day = day;
    }
    public String monthString(){
        int i = this.getMonth();
        String[] months ={"null", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[i];
    }
    /*
     * Constructs a new CalendarDate to represent today.
     * Don't tinker with this code - it will work as soon as YOU
     *   correctly complete the nextDay method
     */ 
    public CalendarDate() {
        this(1970, JANUARY, 1); // start date here
        // computes days since Jan 1, 1970
        int daysSinceEpoch = (int) ((System.currentTimeMillis() + 
            TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
        for (int i = 0; i < daysSinceEpoch; i++) 
            nextDay(); // changes the date stored
    }
    public boolean isAValidDate() {
        boolean val = true;
        if(this.month < 1 || this.month > 12){
            val = false;
        }
        if(this.day > DAYS_PER_MONTH[this.month] || this.day< 1){
            val = false;
        }
        return val;  
    }
    // Returns the number of days from this date to date d.
    // Precondition: this date comes before d
    public int daysUntil(CalendarDate d) {
        CalendarDate when = new CalendarDate(year, month, day); // copy this
        int howMany = 0;
        while (!when.equals(d)) {
            howMany++;
            when.nextDay();
        }
        return howMany;
    }
    /*
     * Returns whether the given object is a CalendarDate that refers to the 
     * same year/month/day as this CalendarDate.
     */ 
    public boolean equals(Object o) {
        // a well-behaved equals method returns false for null and non-CalendarDates
        if (o instanceof CalendarDate) {
            CalendarDate other = (CalendarDate) o;
            return day == other.day && month == other.month && 
                   year == other.year;
        } else {
            return false;
        }
    }
    
    // Returns this Date's day.
    public int getDay() {
        return this.day;
    }
    
    // Returns this Date's month.
    public int getMonth() {
        return this.month;
    }
    
    // Returns this Date's year.
    public int getYear() {
        return this.year; 
    }

    // Returns the day of the week on which this Date occurred,
    // such as "Sunday" or "Wednesday".
    // Hint: 1753/1/1 was a Monday (1)
    public String getDayOfWeek() {
        CalendarDate checkDate = new CalendarDate (1753, 1, 7);
        int i = 0;
        
        
        while(checkDate.equals(this) == false){
            i = 0;
            for(i = 0; i < 7; ++i){
                if(checkDate.equals(this)){
                    return DAY_NAMES[i];
                }
                else{
                    checkDate.nextDay();
                }
            }
            if(i == 7){
                i = 0;
            }
        }
 
        return DAY_NAMES[i]; // right now, every day is Sunday
    }
    
    // Returns whether this Date occurred during a leap year.
    // Leap years are every fourth year, except those that are
    // divisible by 100 and not by 400.
    public boolean isLeapYear() {
        if(this.year % 400 == 0){
            return true;
        }
        if(this.year % 4 == 0){
            if(this.year % 100 == 0){
                return false;
            }else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    
    // Advances this CalendarDate to the next day.
    // This may cause a wrap-around into the next month or year.
    public void nextDay() {
       // your solution goes here
       if(this.day < numDays(this.month)){
           this.day += 1;
        }else if(this.day == numDays(this.month)){
            this.day = 1;
            if(this.month < DECEMBER){
                this.month += 1;
            }else{
                this.month = JANUARY;
                this.year += 1;
            }
        }
    }
    
    // Returns a String representation of this CalendarDate, such as "2005/9/22".
    public String toString() {
        return ""+this.year + "/" + this.month + "/" +this.day +"";  // fix to return correctly formatted date
    }
    
    // Add any helper methods here - they must be declared to be private
    private int numDays(int month) {
        if(this.month == FEBRUARY){
            if(isLeapYear()){
                return 29;
            }
            else{
                return DAYS_PER_MONTH[month];
            }
        }
        else{return DAYS_PER_MONTH[month];
        }
    }
}