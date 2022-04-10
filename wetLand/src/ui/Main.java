package ui;

import java.util.Scanner;
import model.Municipality;

public class Main {
    
    /**
	* "reader" is the reader tool of the project.
	*/
    private Scanner reader;

    /**
	* "theMunicipality" is a private object that connect the Main with the controller class "Municipality".
	*/
    private Municipality theMunicipality;

    public static void main(String[] args) {

        Main Program = new Main();

        Program.initializationController();

        int answer = 0;

        do{
            answer= Program.Menu();
            Program.answerOption(answer);
        }while (answer != 0);
    }

    /**
	* Description: the "Main" method is of type constructor.<br>
	* <b> pre:</b> "reader" must be declared.<br>
	* <b> pos:</b> "reader" is initialized.
	*/
    public Main(){
        reader = new Scanner(System.in);
    }

    /**
	* Description: the "Menu" method print the options of the program.<br>
	* <b> pre:</b> "reader" must be created.<br>
	* @return input int, the selected option
	*/
    public int Menu() {
		int input;
		System.out.println("\n\nProgram menu, type an option\n"+ 
		                    "(1) Create a wetland\n" +
		                    "(2) Record a new species in the wetland.\n" +
		                    "(3) Record an event in the wetland\n"+
                            "(4) Record maintenance plan for the wetland.\n" +
		                    "(5) Maintenance of wetlands in one year\n"+
		                    "(6) Show wetland with fewer species of flora\n"+
                            "(7) Search for wetland given a species name\n"+
                            "(8) Show wetlands information\n"+
                            "(9) Show wetland with the largest number of animals\n"+
		                    "(0) To exit"
	
		);
		input = reader.nextInt();
		reader.nextLine();
		return input;
	}

    /**
	* Description: the "answerOption" method executes the option that the user selected.<br>
    * @param userOption int, the selected option.
	*/
    public void answerOption(int userOption) {
		switch(userOption) {
		case 0: 
			System.out.println("closing the application");
			break;
		case 1:
            registerWetland();
			break;
		case 2:
            registerSpecieInWetland();
			break;
		case 3:
            registerEventToWetland();
			break;
		case 4: 
            registerEnvManagementToWetland();
			break;
		case 5: 
            getEnviromentalMag();
            break;
        case 6:
            getLessFloraSpecies();
            break;
        case 7:
            getSpecieInWetland();
            break;
        case 8:
            getWetlandInfo();
            break;
        case 9:
            getMoreAnimalSpecie();
            break;

		}	
	}

    /**
	* Description: the "initializationController" method create the object "theMunicipality".<br>
    * <b> pos:</b> the "theMunicipality" object is created.
	*/
    public void initializationController(){
        System.out.println("Welcome to the wetlands registry system, enter the municipality");
        String name = reader.nextLine();
        theMunicipality = new Municipality(name);
    }

    /**
	* Description: the "registerWetland" method ask for the information needed to register a wetland and when is done call a method to register the wetland.<br>
	*/
    public void registerWetland(){
        System.out.println("For the registration of a wetland, the following information must be filled out:");
        System.out.println("Indicate the name of the wetland");
        String nm = reader.nextLine();
        System.out.println("Indicate in which area you are located:");
        System.out.println("(1) Urban");
        System.out.println("(2) Rural");
        int locationOption = reader.nextInt();
        String locationZ = "";
        boolean ct = true;
        while(ct==true){
            switch(locationOption){
                case 1:
                    locationZ = "Urban";
                    ct=false;
                    break;
                case 2:
                    locationZ = "Rural";
                    ct=false;
                    break;
                default:
                    System.out.println("Only the values shown are allowed, select from the following options:");
                    System.out.println("(1) Urban");
                    System.out.println("(2) Rural");
                    locationOption = reader.nextInt();
            }
        }
        reader.nextLine();
        String zName = "";
        if(locationZ.equalsIgnoreCase("Urban")){
            System.out.println("Indicate the name of the neighborhood");
            zName = "neighborhood: " + reader.nextLine();
        }
        if(locationZ.equalsIgnoreCase("Rural")){
            System.out.println("Indicate the name of the township");
            zName = "township: " + reader.nextLine();
        }
        System.out.println("Indicate the type of wetland");
        System.out.println("(1) Public");
        System.out.println("(2) Private");
        int tp = reader.nextInt();
        String type = "";
        boolean ct2 = true;
        while(ct2==true){
            switch(tp){
                case 1:
                type = "Public";
                ct2=false;
                break;
                case 2:
                type = "private";
                ct2=false;
                break;
                default:
                System.out.println("Only the values shown are allowed, select from the following options:");
                System.out.println("(1) Public");
                System.out.println("(2) Private");
                tp = reader.nextInt();
            }
        }
        reader.nextLine();
        System.out.println("Enter the Km2 of the wetland (numerical value only)");
        double km2 = reader.nextDouble();
        reader.nextLine();
        System.out.println("Enter wetland photo URL");
        String photo = reader.nextLine();
        System.out.println("Finally, indicate if the wetland is a protected area (Yes/No).");
        String zP = reader.nextLine();
        boolean protectedZone=false;
        if(zP.equalsIgnoreCase("yes")){
            protectedZone=true;
        }else if(zP.equalsIgnoreCase("no")){
            protectedZone=false;
        }else{
            boolean err = true;
            while(err==true){
                System.out.println("Wrongly indicated the previous option");
                System.out.println("please indicate if the wetland is a protected area (Yes/No)");
                zP = reader.nextLine();
                if(zP.equalsIgnoreCase("yes") || zP.equalsIgnoreCase("no")){
                    err = false;
                    if(zP.equalsIgnoreCase("yes")){
                        protectedZone = true;
                    }
                    if(zP.equalsIgnoreCase("no")){
                        protectedZone = false;
                    }
                }
            }
        }
        System.out.println("\n" + theMunicipality.addWetland(nm, zName, locationZ, type, km2, photo, protectedZone));
    }

    /**
	* Description: the "registerSpecieInWetland" method ask for the information needed to register a Specie and when is done, call a method to register the Specie.<br>
	*/
    public void registerSpecieInWetland(){
        System.out.println("Indicate the wetland where the species is to be recorded:");
        String wetlandName = reader.nextLine();
        boolean conf = theMunicipality.findWetland(wetlandName);
        if(conf==true){
            System.out.println("Now indicate the name of the species");
            String nm = reader.nextLine();
            System.out.println("indicate the scientific name of the species");
            String cnm = reader.nextLine();
            System.out.println("Indicate the type of species");
            System.out.println("(1) Terrestrial Flora");
            System.out.println("(2) Aquatic Flora");
            System.out.println("(3) Bird");
            System.out.println("(4) Mammal");
            System.out.println("(5) Aquatic");
            int typeOption = reader.nextInt();
            boolean ct = true;
            String type = "";
            while(ct==true){
                switch(typeOption){
                    case 1:
                        type = "Terrestrial Flora";
                        ct = false;
                        break;
                    case 2:
                        type = "Aquatic Flora";
                        ct = false;
                        break;
                    case 3:
                        type = "Bird";
                        ct = false;
                        break;
                    case 4:
                        type = "Mammal";
                        ct = false;
                        break;
                    case 5:
                        type = "Aquatic";
                        ct = false;
                        break;
                    default:
                        System.out.println("Only the values shown are allowed, select from the following options:");
                        System.out.println("(1) Terrestrial Flora");
                        System.out.println("(2) Aquatic Flora");
                        System.out.println("(3) Bird");
                        System.out.println("(4) Mammal");
                        System.out.println("(5) Aquatic");
                        typeOption = reader.nextInt(); 
                }
            }
            reader.nextLine();
            System.out.println("Is the species to be recorded migratory? (Yes/No)");
            String opMig = reader.nextLine();
            boolean MigSpecie = false;
            if(opMig.equalsIgnoreCase("yes")){
                MigSpecie = true;
            }else if(opMig.equalsIgnoreCase("no")){
                MigSpecie = false;
            }else{
                boolean err = true;
                while(err==true){
                    System.out.println("Wrongly indicated the previous option");
                    System.out.println("please indicate if the species is migratory (Yes/No)");
                    opMig = reader.nextLine();
                    if(opMig.equalsIgnoreCase("yes") || opMig.equalsIgnoreCase("no")){
                        err = false;
                        if(opMig.equalsIgnoreCase("yes")){
                            MigSpecie = true;
                        }
                        if(opMig.equalsIgnoreCase("no")){
                            MigSpecie= false;
                        }
                    }
                }
            }
            System.out.println("\n" + theMunicipality.addSpecieToWetland(wetlandName, nm, cnm, MigSpecie, type));
        }else{
            System.out.println("\n" + "The wetland " + wetlandName + " does not exist or is not registered");
        }
    }

    /**
	* Description: the "registerEventToWetland" method ask for the information needed to register a event and when is done call a method to register the event.<br>
	*/
    public void registerEventToWetland(){
        System.out.println("Indicate the wetland where the event is to be recorded:");
        String wetlandName = reader.nextLine();
        boolean conf = theMunicipality.findWetland(wetlandName);
        if(conf==true){
            System.out.println("Indicate the type of event");
            System.out.println("(1) Maintenance");
            System.out.println("(2) School visits");
            System.out.println("(3) Improvement activities");
            System.out.println("(4) Celebrations");
            System.out.println("(5) Other");
            int tp = reader.nextInt();
            boolean ct = true;
            String type = "";
            while(ct==true){
                switch(tp){
                    case 1:
                        type = "Maintenance";
                        ct = false;
                        break;
                    case 2:
                        type = "School visits";
                        ct = false;
                        break;
                    case 3:
                        type = "Improvement activities";
                        ct = false;
                        break;
                    case 4:
                        type = "Celebrations";
                        ct = false;
                        break;
                    case 5:
                        System.out.println("Indicate the name of the event");
                        type = reader.nextLine();
                        ct = false;
                        break;
                    default:
                        System.out.println("Only the values shown are allowed, select from the following options:");
                        System.out.println("(1) Maintenance");
                        System.out.println("(2) School visits");
                        System.out.println("(3) Improvement activities");
                        System.out.println("(4) Celebrations");
                        System.out.println("(5) Other");
                        tp = reader.nextInt(); 
                }
            }
            reader.nextLine();
            System.out.println("Indicate the name of the person in charge of the event");
            String mang = reader.nextLine();
            System.out.println("Indicate the cost of the event (numerical value only)");
            double cost = reader.nextDouble();
            reader.nextLine();
            System.out.println("Add a description for the event");
            String desc = reader.nextLine();
            System.out.println("Finally add the date of the event (format d/m/yyyy).");
            System.out.print("Day: ");
            int d = reader.nextInt();
            if(d>31){
                boolean err = true;
                while(err){
                    System.out.println("Error in the date, the day cannot be greater than 31. Enter again");
                    int day = reader.nextInt();
                    if(day<=31){
                        err = false;
                        d = day;
                    }
                }
            }
            System.out.print("Month: ");
            int m = reader.nextInt();
            if(m>12){
                boolean err = true;
                while(err){
                    System.out.println("Error in the date, the month cannot be greater than 12. Enter again");
                    int month = reader.nextInt();
                    if(month<=12){
                        err = false;
                        m = month;
                    }
                }
            }
            System.out.print("Year: ");
            int y = reader.nextInt();
            if(m==2 && d>28){
                boolean err = true;
                while(err){
                    System.out.println("Error in the date, the month February (2) cannot have more than 28 days. Please enter the day again");
                    int day = reader.nextInt();
                    if (day<=28){
                        err = false;
                        d=day;
                    }
                }
            }
            System.out.println("\n" + theMunicipality.addEventToWetland(type, wetlandName, mang, cost, desc, d, m, y));
        }
    }
    
    /**
	* Description: the "registerEnvManagementToWetland" method ask for the information needed to register a Enviromental Management and when is done call a method to register the EnvManagement.<br>
	*/
    public void registerEnvManagementToWetland(){
        System.out.println("To record the maintenance plan for a wetland, first indicate the name of the wetland.");
        String wName = reader.nextLine();
        System.out.println("Now indicate the type of maintenance it is:");
        System.out.println("(1) Restoration");
        System.out.println("(2) Maintenance");
        System.out.println("(3) Conservation");
        int magOption = reader.nextInt();
        boolean ct = true;
        String magType = "";
        while(ct==true){
            switch(magOption){
                case 1:
                    magType = "Restoration";
                    ct = false;
                    break;
                case 2:
                    magType = "Maintenance";
                    ct = false;
                    break;
                case 3:
                    magType = "Conservation";
                    ct = false;
                    break;
                default:
                    System.out.println("Only the values shown are allowed, select from the following options:");
                    System.out.println("(1) Restoration");
                    System.out.println("(2) Maintenance");
                    System.out.println("(3) Conservation");
                    magOption = reader.nextInt(); 
            }
        }
        reader.nextLine();
        System.out.println("What is the percentage of compliance with the plan? (numerical value only)");
        double prc = reader.nextDouble()/100;
        System.out.println(theMunicipality.addEnvMag(wName, magType, prc));
    }

    /**
	* Description: the "getEnviromentalMag" method call a method in the controller to get all the Enviromental Managements.<br>
	*/
    public void getEnviromentalMag(){
        System.out.println("The environmental maintenance plans for the registered wetlands are as follows :");
        System.out.println(theMunicipality.showEnvManagements());
    }

    /**
	* Description: the "getLessFloraSpecies" method call a method in the controller to get the wetland with less flora species.<br>
	*/
    public void getLessFloraSpecies(){
       System.out.println("The wetland with the least amount of flora is: ");
       System.out.println(theMunicipality.getLessFlora());
    }

    /**
	* Description: the "getSpecieInWetland" method call a method in the controller to look for a specie in the registered wetlands.<br>
	*/
    public void getSpecieInWetland(){
       System.out.println("Indicate the name of the species to be searched:");
       String nm = reader.nextLine();
       System.out.println(theMunicipality.searchSpecieInWetland(nm));
    }

    /**
	* Description: the "getWetlandInfo" method call a method in the controller to get all the information of the registered wetlands.<br>
	*/
    public void getWetlandInfo(){
        System.out.println("The information recorded for the wetlands so far is as follows:");
        System.out.println(theMunicipality.wetlandInfo());
    }

    /**
	* Description: the "getMoreAnimalSpecie" method call a method in the controller to get the wetland with more animals species registered.<br>
	*/
    public void getMoreAnimalSpecie(){
        System.out.println("The wetland with the largest number of animals is: ");
       System.out.println(theMunicipality.getMoreAnimals());
    }
}
