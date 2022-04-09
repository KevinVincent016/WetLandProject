package model;

public class Municipality {
    
    public static final int MAX_WETLAND = 80;

    private String name;

    private Wetland [] myWetland;

    public Municipality(String nm){
        name = nm;
        myWetland = new Wetland[MAX_WETLAND];
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

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

    public boolean findWetland(String name){
        boolean confirmation = false;
        boolean flag = true;
        for(int i =0; i<MAX_WETLAND && flag==true;i++){
            if(myWetland[i]==null){
                confirmation = false;
                flag = false;
            }
            if(myWetland[i].getName().equalsIgnoreCase(name)){
                confirmation = true;
                flag = false;
            }else{
                confirmation = false;
                flag = false;
            }
        }
        return confirmation;
    }

    public String addWetland(String name, String zName, String locationZone, String type, double km2, String photoURL, boolean protectedArea){
		String out ="";
		int emptyPos = getEmptyPositionWetland();
		if(emptyPos == -1){
			out = "Se ha llenado la cantidad maxima de humedales";
		}else{
			Wetland theWetland = new Wetland(name, zName, locationZone, type, km2, photoURL, protectedArea);
			myWetland[emptyPos] = theWetland;	
			out = "Se agrego el humedal " + name + "de " + zName;
		}
		return out;
	} 

    public String addSpecieToWetland(String Wname, String name, String scientificName, boolean migratorySpecie, String type){
        String out = "";
        boolean flag = true;
        for(int i = 0; i<MAX_WETLAND && flag==true;i++){
            if(myWetland[i].getName().equalsIgnoreCase(Wname)){
                flag = false;
                myWetland[i].addMySpecie(name, scientificName, migratorySpecie, type);
                out += "Se ha registrado la especie " + name + " al humedal " + Wname;
            }else{
                flag = false;
                out += "No se encontro ningun humedal con el nombre " + Wname;
            }
        }
        return out;
    }

    public String addEventToWetland(String Wname, String manager, double cost, String desc, int day, int month, int year){
        String out = "";
        boolean flag = true;
        for(int i = 0; i<MAX_WETLAND && flag==true;i++){
            if(myWetland[i].getName().equalsIgnoreCase(Wname)){
                Date theDate = new Date(day,month,year);
                myWetland[i].addMyEvent(manager, cost, desc, theDate);
                out += "El evento fue registrado exitosamente";
                flag = false;
            }else{
                out += "No se encontro ningun humedal con el nombre " + Wname;
                flag = false;
            }
        }
        return out;
    }

    public String addEnvMag(String Wname, String tp, double percentage){
        String out = "";
        boolean flag = true;
        for(int i = 0; i<MAX_WETLAND && flag==true;i++){
            if(myWetland[i].getName().equalsIgnoreCase(Wname)){
                myWetland[i].addMyEnvMag(tp, percentage);
                out += "El Plan de mantenimiento fue registrado exitosamente";
                flag = false;
            }else{
                out += "No se encontro ningun humedal con el nombre " + Wname;
                flag = false;
            }
        }
        return out;
    }

    public String searchSpecieInWetland(String name){
        boolean cont = false;
        String msg = "";
        for (int i=0; i<MAX_WETLAND && cont==false;i++){
            boolean aux= myWetland[i].isSpecieHere(name);
            if(aux==true){
                msg += "La especie " + name + " se encuentra en el humedal " + myWetland[i].getName();
            }else{
                msg += "La especie " + name + " no se encuentra registrada en ningun humedal";
            }
        }
        return msg;
    }

    public String showEnvManagements(){
        String out = "";
        for(int i=0; i<MAX_WETLAND && myWetland[i]!=null;i++){
            out += "\n" +
            myWetland[i].getName() + "\n" +
            myWetland[i].getEnvManagement() + "\n";
        }
        return out;
    }

}
