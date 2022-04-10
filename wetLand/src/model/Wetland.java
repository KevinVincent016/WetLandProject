package model;

public class Wetland{

    public static final int MAX_ESPECIES = 80;
    public static final int MAX_ENVMANAGEMENTS = 30;
    public static final int MAX_EVENTS = 30;

    /**
	* "name" is a private variable that stores the name of the wetland.
	*/
    private String name;

    /**
	* "xoneName" is a private variable that stores the name of the area where the wetland is located.
	*/
    private String zoneName;
    /**
	* "locationZone" is a private variable that stores the location zone of the wetland.
	*/
    private String locationZone;
    /**
	* "type" is a private variable that stores the type of the wetland.
	*/
    private String type;
    /**
	* "km2" is a private variable that stores the km2 of the wetland.
	*/
    private double km2;
    /**
	* "photoUrl" is a private variable that stores the photo url of the wetland.
	*/
    private String photoUrl;
    /**
	* "protectedArea" is a private variable that stores if the wetland is a protected area.
	*/
    private boolean protectedArea;

    /**
	* "theSpecie" is a private object that stores the information of a Specie.
	*/
    private Specie theSpecie;

    /**
	* "mySpecie" is a private array that stores the species of the wetland.
	*/
    private Specie [] mySpecie;

    /**
	* "myEnvMag" is a private object that stores the information of environmental plan of the wetland.
	*/
    private EnvManagement EnvMag;

    /**
	* "myEnvManagement" is a private array that stores the environmental management plans of the wetland.
	*/
    private EnvManagement [] myEnvMag;

    /**
	* "myEvent" is a private object that stores the events of the wetland.
	*/
    private Event theEvent;

    /**
	* "myEvents" is a private array that stores the information of the events of the wetland.
	*/
    private Event [] myEvents;

    /**
	* Description: the "Wetland" method is of type constructor and assigns the values to the Wetland object.<br>
	* <b> pre:</b> The variables "name", "locationZone", "type", "km2", "photoUrl" and "protectedArea" must be declared.<br>
	* <b> pos:</b> the variables "name", "locationZone", "type", "km2", "photoUrl", "protectedArea" and the arrays "mySpecie", "myEnvMag" and "myEvents" are initialized.
    * @param nm String, name of the wetland.
    * @param zNm String, name location where is the wetland
    * @param lZ String, location of the wetland.
    * @param tp String, type of wetland.
    * @param kM2 double, kM2 of the wetland.
    * @param pUrl String, photo url of the wetland.
    * @param pArea boolean, if wetland is a protected area.
	*/
    public Wetland(String nm, String zNm, String lZ, String tp, double kM2, String pUrl, boolean pArea){
        name = nm;
        zoneName = zNm;
        locationZone = lZ;
        type = tp;
        km2 = kM2;
        photoUrl = pUrl;
        protectedArea = pArea;
        mySpecie = new Specie [MAX_ESPECIES];
        myEnvMag = new EnvManagement [MAX_ENVMANAGEMENTS];
        myEvents = new Event [MAX_EVENTS];
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
	* Description: the setZoneName method modifies the private variable zoneName.<br>
	* <b> pre:</b> The variable "zoneName" must be declared.<br>
	* <b> pos:</b> the variable "zoneName" is modified.
    * @param zNm String, zNm must be initialized.
	*/
    public void setZoneName(String zNm){
        zoneName = zNm;
    }

    /**
	* Description: the getZoneName method returns the value of the zoneName variable.<br>
	* <b> pre:</b> The variable "zoneName" must be initialized.<br>
	* @return zoneName String, zoneName value.
	*/
    public String getZoneName(){
        return zoneName;
    }

    /**
	* Description: the setLocationZone method modifies the private variable locationZone.<br>
	* <b> pre:</b> The variable "locationZone" must be declared.<br>
	* <b> pos:</b> the variable "locationZone" is modified.
    * @param lZ String, lZ must be initialized.
	*/
    public void setLocationZone(String lZ){
        locationZone = lZ;
    }

    /**
	* Description: the getLocationZone method returns the value of the locationZone variable.<br>
	* <b> pre:</b> The variable "locationZone" must be initialized.<br>
	* @return locationZone String, locationZone value.
	*/
    public String getLocationZone(){
        return locationZone;
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
	* Description: the setKm2 method modifies the private variable km2.<br>
	* <b> pre:</b> The variable "km2" must be declared.<br>
	* <b> pos:</b> the variable "km2" is modified.
    * @param kM2 double, kM2 must be initialized.
	*/
    public void setKm2(double kM2){
        km2 = kM2;
    }

    /**
	* Description: the getKm2 method returns the value of the km2 variable.<br>
	* <b> pre:</b> The variable "km2" must be initialized.<br>
	* @return km2 double, km2 value.
	*/
    public double getKm2(){
        return km2;
    }

    /**
	* Description: the setPhotoUrl method modifies the private variable photoUrl.<br>
	* <b> pre:</b> The variable "photoUrl" must be declared.<br>
	* <b> pos:</b> the variable "photoUrl" is modified.
    * @param url String, url must be initialized.
	*/
    public void setPhotoUrl(String url){
        photoUrl = url;
    }

    /**
	* Description: the getPhotoUrl method returns the value of the photoUrl variable.<br>
	* <b> pre:</b> The variable "photoUrl" must be initialized.<br>
	* @return photoUrl String, photoUrl value.
	*/
    public String getPhotoUrl(){
        return photoUrl;
    }

    /**
	* Description: the setProtectedArea method modifies the private variable protectedArea.<br>
	* <b> pre:</b> The variable "protectedArea" must be declared.<br>
	* <b> pos:</b> the variable "protectedArea" is modified.
    * @param pArea boolean, pArea must be initialized.
	*/
    public void setProtectedArea(boolean pArea){
        protectedArea = pArea;
    }

    /**
	* Description: the getProtectedArea method returns the value of the protectedArea variable.<br>
	* <b> pre:</b> The variable "protectedArea" must be initialized.<br>
	* @return protectedArea boolean, protectedArea value.
	*/
    public boolean getProtectedArea(){
        return protectedArea;
    }

    /**
	* Description: the getSpecies method returns all the species in the wetland.<br>
	* <b> pre:</b> The array "mySpecie" must be initialized.<br>
	* @return out String, Species info.
	*/
    public String getSpecies(){
        String out = "";
        for(int i=0;i<MAX_ESPECIES && mySpecie[i]!=null;i++){
            out += mySpecie[i].toString();
        }
        return out;
    }

    /**
	* Description: the getEnvManagement method returns all the environmental management plans in the wetland.<br>
	* <b> pre:</b> The array "myEnvMag" must be initialized.<br>
	* @return out String, environmental management plans info.
	*/
    public String getEnvManagement(){
        String out = "";
        for(int i=0;i<MAX_ENVMANAGEMENTS && myEnvMag[i]!=null;i++){
            out += myEnvMag[i].toString();
        }
        return out;
    }

    /**
	* Description: the getEvent method returns all the events in the wetland.<br>
	* <b> pre:</b> The array "myEvent" must be initialized.<br>
	* @return out String, Events info.
	*/
    public String getEvent(){
        String out = "";
        for(int i=0;i<MAX_EVENTS && myEvents[i]!=null;i++){
            out += myEvents[i].toString();
        }
        return out;
    }

    /**
	* Description: take all the attributes of the wetland and convert it to a String line.<br>
	* @return out String, Wetland info.
	*/
    public String toString() {
        return
            " Name= '" + getName() + "'" + "\n" +
            " Zone= '" + getZoneName() + "'" + "\n" +
            " Location= '" + getLocationZone() + "'" + "\n" +
            " type= '" + getType() + "'" + "\n" +
            " Km2= '" + getKm2() + "'" + "\n" +
            " Photo(URL)= '" + getPhotoUrl() + "'" + "\n" +
            " Protected Area= '" + getProtectedArea() + "'" + "\n" +
            " \n Species= '" + getSpecies() + "'" + "\n" +
            " \n Maintenances= '" + getEnvManagement() + "'" + "\n"
            ;
    }

    /**
	* Description: the getEmptyPositionSpecies method returns the empty position in the Species array.<br>
	* <b> pre:</b> The array "mySpecie" must be initialized.<br>
	* @return position int, empty position.
	*/
    public int getEmptyPositionSpecies(){
        boolean emptyPosition = false;
		int position = -1;
		for (int i=0; i<MAX_ESPECIES && !emptyPosition; i++){
			if(mySpecie[i] == null){
				emptyPosition = true;
				position = i;
			}
		}
		return position;
    }

    /**
	* Description: the addMySpecie method add a Specie to the private array mySpecie.<br>
	* <b> pre:</b> The array "mySpecie" must be declared.<br>
	* <b> pos:</b> the array "mySpecie" is modified.
    * @param nm String, name of the specie.
    * @param cNm String, scientific name of the specie.
    * @param mSpecie boolean, if the specie is a Migratory Specie.
    * @param tp String, type of the specie.
    * @return out String, Validation of the registration.
	*/
    public String addMySpecie(String nm, String cNm, boolean mSpecie, String tp){
        String out = "";
        int emP = getEmptyPositionSpecies();
        if(emP == -1){
            out = "There are too much species, not registered";
        }else{
            theSpecie = new Specie(nm, cNm, mSpecie, tp);
            mySpecie[emP]=theSpecie;
            out += "Specie " + nm + " added sucesfully";
        }
        return out;
    }

    /**
	* Description: the isSpecieHere method look for a determinate specie in the wetland.<br>
    * @param nm String, name of the specie.
    * @return out boolean, indicator of the search.
	*/
    public boolean isSpecieHere(String nm){
        boolean out = false;
        boolean flag = true;
        for(int i=0;i<MAX_ESPECIES && mySpecie[i]!=null && flag==true;i++){
            if(mySpecie[i].getName().equalsIgnoreCase(nm)){
                out = true;
                flag = false;
            }else{
                out = false;
                flag = false;
            }
        }
        return out;
    }

    /**
	* Description: the getEmptyPositionEnvMag method returns the empty position in the Environmental Management array.<br>
	* <b> pre:</b> The array "myEnvMag" must be initialized.<br>
	* @return position int, empty position.
	*/
    public int getEmptyPositionEnvMag(){
        boolean emptyPEnv = false;
		int position = -1;
		for (int i=0; i<MAX_ENVMANAGEMENTS && !emptyPEnv; i++){
			if(myEnvMag[i] == null){
				emptyPEnv = true;
				position = i;
			}
		}
		return position;
    }

    /**
	* Description: the addMyEnvMag method add a EnvManagement to the private array myEnvMag.<br>
	* <b> pre:</b> The array "myEnvMag" must be declared.<br>
	* <b> pos:</b> the array "myEnvMag" is modified.
    * @param tp String, type of the specie.
    * @param percentage double, the percentage of compliance of the plan.
    * @return out String, Validation of the registration.
	*/
    public String addMyEnvMag(String tp, double percentage){
        String out = "";
        int emP = getEmptyPositionEnvMag();
        if(emP == -1){
            out = "There are too much enviromental Managements, not registered";
        }else{
            EnvMag = new EnvManagement(tp, percentage);
            myEnvMag[emP]=EnvMag;
            out += "Enviromental Management added sucesfully";
        }
        return out;
    }

    /**
	* Description: the getEmptyPositionEvent method returns the empty position in the Event array.<br>
	* <b> pre:</b> The array "myEvents" must be initialized.<br>
	* @return position int, empty position.
	*/
    public int getEmptyPositionEvent(){
        boolean emptyPE = false;
		int position = -1;
		for (int i=0; i<MAX_EVENTS && !emptyPE; i++){
			if(myEvents[i] == null){
				emptyPE = true;
				position = i;
			}
		}
		return position;
    }

    /**
	* Description: the addMyEvent method add a Event to the private array myEvents.<br>
	* <b> pre:</b> The array "myEvents" must be declared.<br>
	* <b> pos:</b> the array "myEvents" is modified.
    * @param tp String, type of the event.
    * @param manager String, name of the manager in the event.
    * @param cost double, the cost of the event.
    * @param description String, a description of the event.
    * @param date Date, an object of Date.
    * @return out String, Validation of the registration.
	*/
    public String addMyEvent(String tp, String manager, double cost, String description, Date date){
        String out = "";
        int emP = getEmptyPositionEvent();
        if(emP == -1){
            out = "There are too much Events, not registered";
        }else{
            theEvent = new Event(tp, manager, cost, description, date);
            myEvents[emP]=theEvent;
            out += "Event added sucesfully";
        }
        return out;
    }

    /**
	* Description: the getNumFlora method returns the quantity of flora species in the wetland.<br>
	* @return totalFlora int, Total of flora species.
	*/
    public int getNumFlora(){
        int totalFlora = 0;
        for(int i=0;i<MAX_ESPECIES && mySpecie[i]!=null;i++){
            if(mySpecie[i].getType().equalsIgnoreCase("Terrestrial Flora") || mySpecie[i].getType().equalsIgnoreCase("Aquatic Flora")){
                totalFlora++;
            }
        }
        return totalFlora;
    }

    /**
	* Description: the getNumAnimals method returns the quantity of animals in the wetland.<br>
	* @return totalAnimals int, Total of Animals.
	*/
    public int getNumAnimals(){
        int totalAnimals = 0;
        for(int i=0;i<MAX_ESPECIES && mySpecie[i]!=null;i++){
            if(mySpecie[i].getType().equalsIgnoreCase("Bird") || mySpecie[i].getType().equalsIgnoreCase("Mammal") || mySpecie[i].getType().equalsIgnoreCase("Aquatic")){
                totalAnimals++;
            }
        }
        return totalAnimals;
    }
}