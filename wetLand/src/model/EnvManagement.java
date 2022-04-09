package model;

public class EnvManagement {
    
    /**
	* "day" is a private variable that stores the number of day
	*/
    private String type;

    /**
	* "day" is a private variable that stores the number of day
	*/
    private double compliancePercentage;

    /**
	* Description: the "EnvManagement" method is of type constructor and assigns the values to the EnvManagement object.<br>
	* <b> pre:</b> The variables "type" and "compliancePercentage" must be declared.<br>
	* <b> pos:</b> the variables "type" and "compliancePercentage" are initialized.
    * @param tp String, tp must be initialized.
    * @param comPer double, comPer must be initialized.
	*/
    public EnvManagement(String tp, double comPer){
        type = tp;
        compliancePercentage = comPer;
    }

    /**
	* Description: the setType method modifies the private variable type.<br>
	* <b> pre:</b> The variable "type" must be declared.<br>
	* <b> pos:</b> the variable "type" is modified.
    * @param tp String, tp must be initialized.
	*/
    public void setType(String tp){
        type = tp;
    }

    /**
	* Description: the getType method returns the value of the type variable.<br>
	* <b> pre:</b> The variable "type" must be initialized.<br>
	* @return type String, type value.
	*/
    public String getType(){
        return type;
    }

    /**
	* Description: the setCompliancePercentage method modifies the private variable compliancePercentage.<br>
	* <b> pre:</b> The variable "compliancePercentage" must be declared.<br>
	* <b> pos:</b> the variable "compliancePercentage" is modified.
    * @param comPer double, comPer must be initialized.
	*/
    public void setCompliancePercentage(double comPer){
        compliancePercentage = comPer;
    }

    /**
	* Description: the getCompliancePercentage method returns the value of the compliancePercentage variable.<br>
	* <b> pre:</b> The variable "compliancePercentage" must be initialized.<br>
	* @return compliancePercentage double, compliancePercentage value.
	*/
    public double getCompliancePercentage(){
        return compliancePercentage;
    }

    public String toString() {
        return 
            "\n Tipo='" + getType() + "'" +
            "\n" + " Porcentaje de cumplimiento='" + getCompliancePercentage()*100 + "%" + "'"
            ;
    }
}
