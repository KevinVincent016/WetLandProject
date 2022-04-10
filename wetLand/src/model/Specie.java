package model;

public class Specie {
    
    /**
	* "name" is a private variable that stores the name of the specie.
	*/
    private String name;
    /**
	* "scientificName" is a private variable that stores the scientific name of the specie.
	*/
    private String scientificName;
    /**
	* "migratorySpecie" is a private variable that stores if the specie is a migratory specie.
	*/
    private boolean migratorySpecie;
    /**
	* "type" is a private variable that stores the type of the specie.
	*/
    private String type;

    /**
	* Description: the "Specie" method is of type constructor and assigns the values to the Specie object.<br>
	* <b> pre:</b> The variables "name", "scientificName", "migratorySpecie" and "type" must be declared.<br>
	* <b> pos:</b> the variables "name", "scientificName", "migratorySpecie" and "type" are initialized.
    * @param nm String, nm must be initialized.
    * @param cnm String, cnm must be initialized.
    * @param mSpecie boolean, mSpecie must be initialized.
    * @param tp String, tp must be initialized.
	*/
    public Specie(String nm, String cnm, boolean mSpecie, String tp){
        name = nm;
        scientificName = cnm;
        migratorySpecie = mSpecie;
        type = tp;
    }

    /**
	* Description: the setName method modifies the private variable name.<br>
	* <b> pre:</b> The variable "name" must be declared.<br>
	* <b> pos:</b> the variable "name" is modified.
    * @param nm String, nm must be initialized.
	*/
    public void setName(String nm){
        name = nm;
    }

    /**
	* Description: the getName method returns the value of the name variable.<br>
	* <b> pre:</b> The variable "name" must be initialized.<br>
	* @return name String, name value.
	*/
    public String getName(){
        return name;
    }

    /**
	* Description: the setScientificName method modifies the private variable scientificName.<br>
	* <b> pre:</b> The variable "scientificName" must be declared.<br>
	* <b> pos:</b> the variable "scientificName" is modified.
    * @param cnm String, cnm must be initialized.
	*/
    public void setScientificName(String cnm){
        scientificName = cnm;
    }

    /**
	* Description: the getScientificName method returns the value of the scientificName variable.<br>
	* <b> pre:</b> The variable "scientificName" must be initialized.<br>
	* @return scientificName String, scientificName value.
	*/
    public String getScientificName(){
        return scientificName;
    }

    /**
	* Description: the setMigratorySpecie method modifies the private variable migratorySpecie.<br>
	* <b> pre:</b> The variable "migratorySpecie" must be declared.<br>
	* <b> pos:</b> the variable "migratorySpecie" is modified.
    * @param mSpecie boolean, mSpecie must be initialized.
	*/
    public void setMigratorySpecie(boolean mSpecie){
        migratorySpecie = mSpecie;
    }

    /**
	* Description: the getMigratorySpecie method returns the value of the migratorySpecie variable.<br>
	* <b> pre:</b> The variable "migratorySpecie" must be initialized.<br>
	* @return migratorySpecie boolean, migratorySpecie value.
	*/
    public boolean getMigratorySpecie(){
        return migratorySpecie;
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
	* Description: take all the attributes of the Specie and convert it to a String line.<br>
	* @return out String, Specie info.
	*/
    public String toString() {
        return 
            " \n Name= '" + getName() + "'" +
            " \n Scientific name= '" + getScientificName() + "'" +
            " \n Migratory Specie= '" + getMigratorySpecie() + "'" +
            " \n Type= '" + getType() + "'"
            ;
    }
    
}
