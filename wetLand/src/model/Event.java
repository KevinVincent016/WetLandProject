package model;

public class Event {
    
    /**
	* "manager" is a private variable that stores the name of the manager.
	*/
    private String manager;
    /**
	* "cost" is a private variable that stores the cost of the event.
	*/
    private double cost;
    /**
	* "description" is a private variable that stores the description of the event.
	*/
    private String description;

    /**
	* "theDate" is a private variable that stores the date of the event
	*/
    private Date theDate;

    /**
	* Description: the "Event" method is of type constructor and assigns the values to the Event object.<br>
	* <b> pre:</b> The variables "manager", "cost" and "description" must be declared.<br>
	* <b> pos:</b> the variables "manager", "cost" and "description" are initialized.
    * @param mg String, mg must be initialized.
    * @param cst double, cst must be initialized.
    * @param dec String, dec must be initialized.
	*/
    public Event(String mg, double cst, String dec, Date dt){
        manager = mg;
        cost = cst;
        description = dec;
        theDate = dt;
    }

    /**
	* Description: the setManager method modifies the private variable manager.<br>
	* <b> pre:</b> The variable "manager" must be declared.<br>
	* <b> pos:</b> the variable "manager" is modified.
    * @param mg String, mg must be initialized.
	*/
    public void setManager(String mg){
        manager = mg;
    }

    /**
	* Description: the getManager method returns the value of the manager variable.<br>
	* <b> pre:</b> The variable "manager" must be initialized.<br>
	* @return manager String, manager value.
	*/
    public String getManager(){
        return manager;
    }

    /**
	* Description: the setCost method modifies the private variable cost.<br>
	* <b> pre:</b> The variable "cost" must be declared.<br>
	* <b> pos:</b> the variable "cost" is modified.
    * @param cst double, cst must be initialized.
	*/
    public void setCost(double cst){
        cost = cst;
    }

    /**
	* Description: the getCost method returns the value of the cost variable.<br>
	* <b> pre:</b> The variable "cost" must be initialized.<br>
	* @return cost double, cost value.
	*/
    public double getCost(){
        return cost;
    }

    /**
	* Description: the setDescription method modifies the private variable description.<br>
	* <b> pre:</b> The variable "description" must be declared.<br>
	* <b> pos:</b> the variable "description" is modified.
    * @param desc String, desc must be initialized.
	*/
    public void setDescription(String desc){
        description = desc;
    }

    /**
	* Description: the getDescription method returns the info of the description variable.<br>
	* <b> pre:</b> The variable "description" must be initialized.<br>
	* @return description String, description value.
	*/
    public String getDescription(){
        return description;
    }

    /**
	* Description: the setTheDate method modifies the private variable theDate.<br>
	* <b> pre:</b> The variable "theDate" must be declared.<br>
	* <b> pos:</b> the variable "theDate" is modified.
    * @param date Date, date must be initialized.
	*/
    public void setTheDate(Date date){
        theDate = date;
    }

    /**
	* Description: the getTheDate method returns the value of the theDate variable.<br>
	* <b> pre:</b> The variable "theDate" must be initialized.<br>
	* @return theDate Date, theDate object.
	*/
    public Date getTheDate(){
        return theDate;
    }

    public String toString() {
        return "\n" +
            " manager='" + getManager() + "'" +
            "\n cost='" + getCost() + "'" +
            "\n description='" + getDescription() + "'" +
            "\n theDate='" + getTheDate() + "'" +
            "\n";
    }

}
