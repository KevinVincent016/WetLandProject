package model;

public class Date{

    /**
	* "day" is a private variable that stores the number of day
	*/
    private int day;
    /**
	* "month" is a private variable that stores the number of month
	*/
    private int month;
    /**
	* "year" is a private variable that stores the number of year
	*/
    private int year;

    /**
	* Description: the "Date" method is of type constructor and assigns the values to the Date object.<br>
	* <b> pre:</b> The variables "day", "month" and "year" must be declared.<br>
	* <b> pos:</b> the variables "day", "month" and "year" are initialized.
    * @param d int, d must be initialized.
    * @param m int, m must be initialized.
    * @param y int, y must be initialized.
	*/
    public Date(int d, int m, int y){
        day = d;
        month = m;
        year = y;
    }

    /**
	* Description: the setDay method modifies the private variable day.<br>
	* <b> pre:</b> The variable "day" must be declared.<br>
	* <b> pos:</b> the variable "day" is modified.
    * @param d int, d must be initialized.
	*/
    public void setDay(int d){
        day = d;
    }

    /**
	* Description: the getDay method returns the value of the day variable.<br>
	* <b> pre:</b> The variable "day" must be initialized.<br>
	* @return day int, day value.
	*/
    public int getDay(){
        return day;
    }

    /**
	* Description: the setMonth method modifies the private variable month.<br>
	* <b> pre:</b> The variable "month" must be declared.<br>
	* <b> pos:</b> the variable "month" is modified.
    * @param m int, m must be initialized.
	*/
    public void setMonth(int m){
        month = m;
    }

    /**
	* Description: the getMonth method returns the value of the month variable.<br>
	* <b> pre:</b> The variable "month" must be initialized.<br>
	* @return month int, month value.
	*/
    public int getMonth(){
        return month;
    }

    /**
	* Description: the setYear method modifies the private variable year.<br>
	* <b> pre:</b> The variable "year" must be declared.<br>
	* <b> pos:</b> the variable "year" is modified.
    * @param y int, y must be initialized.
	*/
    public void setYear(int y){
        year = y;
    }

    /**
	* Description: the getYear method returns the value of the year variable.<br>
	* <b> pre:</b> The variable "year" must be initialized.<br>
	* @return year int, year value.
	*/
    public int getYear(){
        return year;
    }

}