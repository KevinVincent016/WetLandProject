package model;

public class Municipality {
    
    public static final int MAX_WETLAND = 80;

    /**
	* "name" is a private variable that stores the name of the municipality.
	*/
    private String name;

    /**
	* "myWetland" is a private array that stores the wetlands.
	*/
    private Wetland [] myWetland;

    /**
	* Description: the "Municipality" method is of type constructor and assigns the values to the Municipality object.<br>
	* <b> pre:</b> The variable "name" must be declared.<br>
	* <b> pos:</b> the variables "name" and the array "myWetland" are initialized.
    * @param nm String, name must be declared.
	*/
    public Municipality(String nm){
        name = nm;
        myWetland = new Wetland[MAX_WETLAND];
    }

    /**
     * Description: the getName method returns the value of the name variable.<br>
	 * <b> pre:</b> The variable "name" must be initialized.<br>
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Description: the setName method modifies the private variable name.<br>
	 * <b> pre:</b> The variable "name" must be declared.<br>
	 * <b> pos:</b> the variable "name" is modified.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
	* Description: the getEmptyPositionWetland method returns the empty position in the Wetland array.<br>
	* <b> pre:</b> The array "myWetland" must be initialized.<br>
	* @return position int, empty position.
	*/
    public int getEmptyPositionWetland(){
        boolean emptyPosition = false;
		int position = -1;
		for (int i=0; i<MAX_WETLAND && !emptyPosition; i++){
			if(myWetland[i] == null){
				emptyPosition = true;
				position = i;
			}
		}
		return position;
    }

    /**
	* Description: the findWetland method returns a validation if finds a determinate specie in a wetland.<br>
	* <b> pre:</b> The array "myWetland" must be initialized.<br>
	* @return confirmation boolean, validation.
	*/
    public boolean findWetland(String name){
        boolean confirmation = false;
        boolean flag = true;
        for(int i =0; i<MAX_WETLAND && myWetland[i]!=null && flag==true;i++){
            if(myWetland[i]==null){
                confirmation = false;
                flag = false;
            }
            if(myWetland[i].getName().equalsIgnoreCase(name)){
                confirmation = true;
                flag = false;
            }else{
                confirmation = false;
            }
        }
        return confirmation;
    }

    /**
	* Description: the addWetland method add a Wetland to the private array myWetland.<br>
	* <b> pre:</b> The array "myWetland" must be declared.<br>
	* <b> pos:</b> the array "myWetland" is modified.
    * @param name String, name of the wetland.
    * @param zName String, name of the location of the wetland.
    * @param locationZone String, type of location where is the wetland.
    * @param type String, type of the wetland.
    * @param km2 double, the Km2 of the wetland.
    * @param photoURL String, the link of a photo of the wetland.
    * @param protectedArea boolean, indication if the wetland is a protected area.
    * @return out String, Validation of the registration.
	*/
    public String addWetland(String name, String zName, String locationZone, String type, double km2, String photoURL, boolean protectedArea){
		String out ="";
		int emptyPos = getEmptyPositionWetland();
		if(emptyPos == -1){
			out = "Se ha llenado la cantidad maxima de humedales";
		}else{
			Wetland theWetland = new Wetland(name, zName, locationZone, type, km2, photoURL, protectedArea);
			myWetland[emptyPos] = theWetland;	
			out = "Se agrego el humedal " + name + " del " + zName;
		}
		return out;
	} 

    /**
	* Description: the addSpecieToWetland method add a Specie to a determinate wetland.<br>
	* <b> pre:</b> The array "myWetland" must be declared.<br>
	* <b> pos:</b> the array "myWetland" is modified.
    * @param wName String, name of the wetland where the specie will be add.
    * @param name String, name of the specie.
    * @param scientificName String, scientific name of the specie.
    * @param migratorySpecie boolean, if the specie is a Migratory Specie.
    * @param type String, type of the specie.
    * @return out String, Validation of the registration.
	*/
    public String addSpecieToWetland(String wName, String name, String scientificName, boolean migratorySpecie, String type){
        String out = "";
        boolean flag = true;
        for(int i = 0; i<MAX_WETLAND && flag==true;i++){
            if(myWetland[i].getName().equalsIgnoreCase(wName)){
                flag = false;
                myWetland[i].addMySpecie(name, scientificName, migratorySpecie, type);
                out = "Se ha registrado la especie " + name + " al humedal " + wName;
            }else{
                out += "No se encontro ningun humedal con el nombre " + wName;
            }
        }
        return out;
    }

    /**
	* Description: the addEventToWetland method add a Event to a determinate wetland.<br>
	* <b> pre:</b> The array "myWetland" must be declared.<br>
	* <b> pos:</b> the array "myWetland" is modified.
    * @param wName String, name of the wetland where the event will be add.
    * @param manager String, name of the manager of the event.
    * @param cost double, cost of the event.
    * @param desc String, a description of the event.
    * @param day int, day of the event.
    * @param month int, month of the event.
    * @param year int, year of the event.
    * @return out String, Validation of the registration.
	*/
    public String addEventToWetland(String wName, String manager, double cost, String desc, int day, int month, int year){
        String out = "";
        boolean flag = true;
        for(int i = 0; i<MAX_WETLAND && flag==true;i++){
            if(myWetland[i].getName().equalsIgnoreCase(wName)){
                Date theDate = new Date(day,month,year);
                myWetland[i].addMyEvent(manager, cost, desc, theDate);
                out = "El evento fue registrado exitosamente";
                flag = false;
            }else{
                out += "No se encontro ningun humedal con el nombre " + wName;
            }
        }
        return out;
    }

    /**
	* Description: the addEnvMag method add a environmental management to a determinate wetland.<br>
	* <b> pre:</b> The array "myWetland" must be declared.<br>
	* <b> pos:</b> the array "myWetland" is modified.
    * @param wName String, name of the wetland where the envMag will be add.
    * @param tp String, type of the envMag.
    * @param percentage double, percentage of compliance of the envMag.
    * @return out String, Validation of the registration.
	*/
    public String addEnvMag(String wName, String tp, double percentage){
        String out = "";
        boolean flag = true;
        for(int i = 0; i<MAX_WETLAND && flag==true;i++){
            if(myWetland[i].getName().equalsIgnoreCase(wName)){
                myWetland[i].addMyEnvMag(tp, percentage);
                out = "El Plan de mantenimiento fue registrado exitosamente";
                flag = false;
            }else{
                out += "No se encontro ningun humedal con el nombre " + wName;
            }
        }
        return out;
    }

    /**
	* Description: the searchSpecieInWetland method look a determinate specie in all the wetlands.<br>
	* <b> pre:</b> The array "myWetland" must be declared.<br>
	* <b> pos:</b> the array "myWetland" is modified.
    * @param name String, name of the specie.
    * @return msg String, Name of the wetland where is the specie indicated.
	*/
    public String searchSpecieInWetland(String name){
        boolean cont = false;
        String msg = "";
        for (int i=0; i<MAX_WETLAND && myWetland[i]!=null && cont==false;i++){
            boolean aux= myWetland[i].isSpecieHere(name);
            if(aux==true){
                msg = "La especie " + name + " se encuentra en el humedal " + myWetland[i].getName();
                cont = true;
            }else{
                msg += "La especie " + name + " no se encuentra registrada en ningun humedal";
            }
        }
        return msg;
    }

    /**
	* Description: the showEnvManagements method print all the environmental management plans of all registered wetlands.<br>
	* <b> pre:</b> The array "myWetland" must be declared.<br>
	* <b> pos:</b> the array "myWetland" is modified.
    * @return out String, all the environmental management plans.
	*/
    public String showEnvManagements(){
        String out = "";
        for(int i=0; i<MAX_WETLAND && myWetland[i]!=null;i++){
            out += "\n" + 
            "Humedal: " + myWetland[i].getName() + "\n" +
            myWetland[i].getEnvManagement() + "\n";
        }
        return out;
    }

    /**
	* Description: the getLessFlora method get the wetland with less flora of all wetlands.<br>
	* <b> pre:</b> The array "myWetland" must be declared.<br>
	* <b> pos:</b> the array "myWetland" is modified.
    * @return nameMin String, Name of the wetland where are less flora.
	*/
    public String getLessFlora(){
        int min = myWetland[0].getNumFlora();
        String nameMin = myWetland[0].getName();
        for(int i=0;i<MAX_WETLAND && myWetland[i]!=null;i++){
            if(min>myWetland[i].getNumFlora()){
                min = myWetland[i].getNumFlora();
                nameMin = myWetland[i].getName() + " con " +myWetland[i].getNumFlora() + " cantidad de especies de flora";
            }
        }
        return nameMin;
    }

    /**
	* Description: the wetlandInfo method shows all the information registered of the wetlands.<br>
	* <b> pre:</b> The array "myWetland" must be declared.<br>
	* <b> pos:</b> the array "myWetland" is modified.
    * @return out String, wetlands information.
	*/
    public String wetlandInfo(){
        String out = "";
        for(int i=0; i<MAX_WETLAND && myWetland[i]!=null;i++){
            out += "\n" + 
            "******************* \n" + myWetland[i].toString() + "******************* \n";
        }
        return out;
    }

    /**
	* Description: the getMoreAnimals method get the wetland with More Animal species registered of all wetlands.<br>
	* <b> pre:</b> The array "myWetland" must be declared.<br>
	* <b> pos:</b> the array "myWetland" is modified.
    * @return nameMax String, Name of the wetland where are more animals.
	*/
    public String getMoreAnimals(){
        int max = myWetland[0].getNumAnimals();
        String nameMax = myWetland[0].getName();
        for(int i=0;i<MAX_WETLAND && myWetland[i]!=null;i++){
            if(max<myWetland[i].getNumAnimals()){
                max = myWetland[i].getNumFlora();
                nameMax = myWetland[i].getName() + " con " + myWetland[i].getNumFlora() + " cantidad de Animales";
            }
        }
        return nameMax;
    }
}
